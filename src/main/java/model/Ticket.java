package model;

import java.util.Date;
import java.util.List;
import model.User;

public class Ticket {
	
	private int id; // Ticket's unique id.
	private String username; // The user who requested the ticket.
	private String userFirstName;
	private String userLastName;
	private List<User> technicians;
	private Progress currentProgress;
	private Priority currentPriority;
	private String phone; // Requestor's phone
	private String email; // Requestor's email. May be different from the User's login email.
	private String department;

	private enum Progress {
		OPEN(0), INPROGRESS(1), ONHOLD(2), COMPLETED(3), CLOSED(4);

		private int progress;

		Progress(int progress) {
			this.progress = progress;
		};

		public String getProgressValue() {
			String progress = "";
			switch(this.progress)
			{
			case 0:
				progress = "OPEN";
				break;
			case 1:
				progress = "IN PROGRESS";
				break;
			case 2:
				progress = "ON HOLD";
				break;
			case 3:
				progress = "COMPLETED";
				break;
			case 4:
				progress = "CLOSED";
				break;
			}
			return progress;
		}

	};
	
	private enum Priority {
		NA(0), LOW(1), MEDIUM(2), HIGH(3);
		private int priority;
		
		Priority(int priority){
			this.priority = priority;
		}
		
		public String getPriorityValue(){
			String priority = "";
			switch(this.priority){
			case 0:
				priority = "NOT ASSIGNED";
				break;
			case 1:
				priority = "LOW";
				break;
			case 2:
				priority = "MEDIUM";
				break;
			case 3:
				priority = "HIGH";
				break;
			}
			return priority;
		}
		
		public int getPriorityNumericValue(){
			return this.priority;
		}
	};

	// Constant values that apply to the status of a project
	// private Status status; //<-- This was changed into a list of comments
	private int unitId;
	private String details; // Text concerning the project.
	private Date startDate; // Project's starting date.
	private Date endDate; // Project's completed date.
	private Date lastUpdated;
	private String lastUpdatedTime;
	private String ticketLocation; // Location where the project is.
	private List<Update> updates;
	// Needs more work...
	private String completionDetails; // Information pertaining vendors, cost,
										// materials used.

	// Full constructor for every field, probably need when pulling existing
	// data from database
	public Ticket(int id, String username, String firstName, String lastName, List<User> technician, String phone, String email, String department, int progress, int priority, 
			int unitId, String details, Date startDate, Date endDate, Date lastUpdated, String lastUpdatedTime, String ticketLocation, List<Update> updates, 
			String completionDetails) {
		this.id = id;
		this.username = username;
		this.userFirstName = firstName;
		this.userLastName = lastName;
		this.technicians = technician;
		this.phone = phone;
		this.email = email;
		this.department = department;

		switch (progress) {
		case 0:
		default:
			this.currentProgress = Progress.OPEN;
			break;
		case 1:
			this.currentProgress = Progress.INPROGRESS;
			break;
		case 2:
			this.currentProgress = Progress.ONHOLD;
			break;
		case 3:
			this.currentProgress = Progress.COMPLETED;
			break;
		case 4:
			this.currentProgress = Progress.CLOSED;
			break;
		}
		
		switch (priority) {
		case 0:
		default:
			this.currentPriority = Priority.NA;
			break;
		case 1:
			this.currentPriority = Priority.LOW;
			break;
		case 2:
			this.currentPriority = Priority.MEDIUM;
			break;
		case 3:
			this.currentPriority = Priority.HIGH;
			break;
		}
		
		this.unitId = unitId;
		this.details = details;
		this.startDate = startDate;
		this.endDate = endDate;
		this.lastUpdated = lastUpdated;
		this.lastUpdatedTime = lastUpdatedTime;
		this.updates = updates;
		this.ticketLocation = ticketLocation;
		this.completionDetails = completionDetails;

	}
	// Constructor without updates list and technicians list
	public Ticket(int id, String username, String userFirstName, String userLastName, String phone, String email, String department, int priority, int unitId, 
			String details, Date startDate, Date lastUpdated, String ticketLocation) {
		this.id = id;
		this.username = username;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.phone = phone;
		this.email = email;
		this.department = department;
		this.unitId = unitId;
		this.details = details;
		this.startDate = startDate;
		this.lastUpdated = lastUpdated;
		this.ticketLocation = ticketLocation;
		
		switch (priority) {
		case 0:
		default:
			this.currentPriority = Priority.NA;
			break;
		case 1:
			this.currentPriority = Priority.LOW;
			break;
		case 2:
			this.currentPriority = Priority.MEDIUM;
			break;
		case 3:
			this.currentPriority = Priority.HIGH;
			break;
		}
	}
	
	// Constructor without updates list
	public Ticket(int id, String username, String userFirstName, String userLastName, String phone, String email, String department, int priority,
			int unitId, String details, Date startDate, Date lastUpdated, String ticketLocation, List<User> technicianList){
		this.id = id;
		this.username = username;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.phone = phone;
		this.email = email;
		this.unitId = unitId;
		this.details = details;
		this.startDate = startDate;
		this.lastUpdated = lastUpdated;
		this.ticketLocation = ticketLocation;
		this.technicians = technicianList;
		
		switch (priority) {
		case 0:
		default:
			this.currentPriority = Priority.NA;
			break;
		case 1:
			this.currentPriority = Priority.LOW;
			break;
		case 2:
			this.currentPriority = Priority.MEDIUM;
			break;
		case 3:
			this.currentPriority = Priority.HIGH;
			break;
		}
		this.department = department;
	}
	
	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}
	
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUser() {
		return username;
	}

	public void setUser(String user) {
		this.username = user;
	}

	public List<User> getTechnicians() {
		return technicians;
	}

	public void addTechnician(User technician) {
		this.technicians.add(technician);
	}
	
	public void removeTechnician(User technician){
		if(this.getNumOfTechnician() > 0){
			for(int i = 0; i < this.getNumOfTechnician(); i ++ ){
				if(this.technicians.get(i).getId() == technician.getId()){
					this.technicians.remove(i);
				}
			}
		}
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDetails() {
		return details;
	}
	
	public String getDepartment(){
		return this.department;
	}
	
	public void setDepartment(String department){
		this.department = department;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	public Date getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public String getLastUpdateTime() {
		return lastUpdatedTime;
	}

	public void setLastUpdateTime(String lastUpdateTime) {
		this.lastUpdatedTime = lastUpdateTime;
	}

	public String getTicketLocation() {
		return ticketLocation;
	}

	public void setTicketLocation(String ticketLocation) {
		this.ticketLocation = ticketLocation;
	}

	public String getCompletionDetails() {
		return completionDetails;
	}

	public void setCompletionDetails(String completionDetails) {
		this.completionDetails = completionDetails;
	}

	public List<Update> getUpdates() {
		return updates;
	}

	public void setUpdates(List<Update> updateComments) {
		this.updates = updateComments;
	}

	public String getProgress() {
		return this.currentProgress.getProgressValue();
	}

	public void setProgress(int progress) {
		switch (progress) {
		case 0:
			this.currentProgress = Progress.OPEN;
			break;
		case 1:
			this.currentProgress = Progress.INPROGRESS;
			break;
		case 2:
			this.currentProgress = Progress.ONHOLD;
			break;
		case 3:
			this.currentProgress = Progress.COMPLETED;
			break;
		case 4:
			this.currentProgress = Progress.CLOSED;
			break;
		default:
			break; // Does nothing if it is outside range
		}
	}
	
	public String getPriority(){
		return this.currentPriority.getPriorityValue();
	}
	
	public void setPriority(int priority){
		switch (priority) {
		case 0:
			this.currentPriority = Priority.NA;
			break;
		case 1:
			this.currentPriority = Priority.LOW;
			break;
		case 2:
			this.currentPriority = Priority.MEDIUM;
			break;
		case 3:
			this.currentPriority = Priority.HIGH;
			break;
		default: 
			break;
		}
	}
	
	public int getPriorityNumeric(){
		return this.currentPriority.getPriorityNumericValue();
	}
	
	public int getNumOfTechnician(){
		return this.technicians.size();
	}
	
	public int getNumOfUpdates(){
		return this.updates.size();
	}

	public int getUnitId() {
		return unitId;
	}

	public void setUnitId(int unitId) {
		this.unitId = unitId;
	}

	public String toString(){
		return "Ticket #: " + this.id + "\n"
				+ "Requestor's Name: " + this.userFirstName + " " 
				+ this.userLastName + "\n" 
				+ "Location: " + this.ticketLocation +"\n"
				+ "Department:" + this.department + "\n"
				+ "Details: " + this.details;
	}
	
	public boolean isTechnician(String username){
		for(int i = 0; i < this.technicians.size(); i ++){
			if(this.technicians.get(i).getUsername().equals(username)){
				return true;
			}
		}
		return false;
	}
	
}
