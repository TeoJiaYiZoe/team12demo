package sg.edu.nus.team12.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sg.edu.nus.team12.model.LeaveApplication;

@Repository

public interface ManagerRepository extends JpaRepository<LeaveApplication,Integer> {

	
	public List<LeaveApplication> findByStatus(String status);
}
