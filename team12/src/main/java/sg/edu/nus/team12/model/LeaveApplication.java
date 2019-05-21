package sg.edu.nus.team12.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.validator.constraints.Length;

@Entity
public class LeaveApplication {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int staff_id;
	private String start_date;
	private String end_date;
	private String reason;
	private String status;
	@Column(name="LEAVETYPE_ID")
	private int leavetype_id;
	@Length(min = 4)
	private String comment;

	@OneToOne
	@JoinColumn(name="LEAVETYPE_ID",insertable=false,updatable=false)
	private LeaveType leavetype;
	
	@ManyToOne
	@JoinColumn(name="STAFF_ID",insertable=false,updatable=false)
	private Staff staff;
	
	
	public Staff getStaff() {
		return staff;
	}



	public void setStaff(Staff staff) {
		this.staff = staff;
	}



	public LeaveType getLeavetype() {
		return leavetype;
	}



	public void setLeavetype(LeaveType leavetype) {
		this.leavetype = leavetype;
	}



	public LeaveApplication() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public LeaveApplication(int staff_id, String start_date, String end_date, String reason, String status,
			int leavetype_id, String comment) {
		super();
		this.staff_id = staff_id;
		this.start_date = start_date;
		this.end_date = end_date;
		this.reason = reason;
		this.status = status;
		this.leavetype_id = leavetype_id;
		this.comment = comment;
	}



	
	
	@Override
	public String toString() {
		return "leave_application [id=" + id + ", staff_id=" + staff_id + ", start_date=" + start_date + ", end_date="
				+ end_date + ", reason=" + reason + ", status=" + status + ", leavetype_id=" + leavetype_id
				+ ", comment=" + comment + "]";
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getStaff_id() {
		return staff_id;
	}
	public void setStaff_id(int staff_id) {
		this.staff_id = staff_id;
	}
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getLeavetype_id() {
		return leavetype_id;
	}
	public void setLeavetype_id(int leavetype_id) {
		this.leavetype_id = leavetype_id;
	}
	
	
}
