package sg.edu.nus.team12.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import sg.edu.nus.team12.model.LeaveApplication;
import sg.edu.nus.team12.repo.ManagerRepository;

@Controller
public class ManagerController {

	private ManagerRepository managerRepository;
	
	@Autowired
	public void setManagerRepository(ManagerRepository managerRepository) {
		this.managerRepository = managerRepository;
	}
	
	@RequestMapping(path="/")
	public String index() {
		return "index";
	}

    @RequestMapping(path = "/leaverequest", method = RequestMethod.POST)
    public String save(@Valid LeaveApplication leave_application, BindingResult bindingResult) {
    	if (bindingResult.hasErrors()) {
            return "Editform";
        }
        managerRepository.save(leave_application);
        return "redirect:/leaverequest";
    }
    @RequestMapping(path = "/leaverequest", method = RequestMethod.GET)
    public String getAll(Model model) {
    	String s="APPLIED";
    	List<LeaveApplication> list = managerRepository.findByStatus(s);
        model.addAttribute("leave_application", list);
        return "Request";
    }

    @RequestMapping(path = "/leaverequest/edit/{id}", method = RequestMethod.GET)
    public String edit(Model model, @PathVariable(value = "id") Integer id) {   	
    	LeaveApplication leave_application= managerRepository.findById(id).orElse(null);
    	System.out.println(leave_application);
        model.addAttribute("leave_application", leave_application);
        return "Editform";
    }
}
