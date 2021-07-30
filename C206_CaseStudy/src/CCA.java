

public class CCA {
	private int id;
	private String title;
	private String description;
	private int classSize;
	private String dayOfTheWeek;
	private Double startTime;
	private Double endTime;
	private String venue; 
	private String instructorName;
	
	public CCA(int id,String title, String description, int classSize, String dayOfTheWeek, double startTime, double endTime, String venue, String instructorName) {
		this.id=id;
		this.title = title;
		this.description = description;
		this.classSize = classSize;
		this.dayOfTheWeek = dayOfTheWeek;
		this.startTime = startTime;
		this.endTime = endTime;
		this.venue = venue;
		this.instructorName = instructorName;
	}
	
	public int getCcaId() {
		return id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String newTitle) {
		title = newTitle;
	}
	
	
	public String getdescription() {
		return description;
	}
	
	public void setdescription(String newdescription) {
		description = newdescription;
	}
	
	
	public int getClassSize() {
		return classSize;
	}
	
	public void setClassSize(int newClassSize) {
		classSize = newClassSize;
	}
	
	public String getDayOfTheWeek() {
		return dayOfTheWeek;
	}
	
	public void setDayOfTheWeek(String newDayOfTheWeek) {
		dayOfTheWeek = newDayOfTheWeek;
	}
	
	public double getStartTime() {
		return startTime;
	}
	
	public void setStartTime(double newStartTime) {
		startTime = newStartTime;
	}
	
	public double getEndTime() {
		return endTime;
	}
	
	public void setEndTime(double newEndTime) {
		endTime = newEndTime;
	}
	
	public String getVenue() {
		return venue;
	}
	
	public void setVenue(String newVenue) {
		venue = newVenue;
	}
	
	public String getInstructorName() {
		return instructorName;
	}
	
	public void setInstructorName(String newInstructorName) {
		instructorName = newInstructorName;
	}
}