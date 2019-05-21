package sg.edu.nus.team12.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="staff")
public class Staff {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int staffid;
	@Column(name="NAME")
	private String staffname;
	public Staff() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Staff(int staffid, String staffname) {
		super();
		this.staffid = staffid;
		this.staffname = staffname;
	}
	@Override
	public String toString() {
		return "Staff [staffid=" + staffid + ", staffname=" + staffname + "]";
	}
	public int getStaffid() {
		return staffid;
	}
	public void setStaffid(int staffid) {
		this.staffid = staffid;
	}
	public String getStaffname() {
		return staffname;
	}
	public void setStaffname(String staffname) {
		this.staffname = staffname;
	}
	
}
