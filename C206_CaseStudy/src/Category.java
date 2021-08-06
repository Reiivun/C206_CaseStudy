import java.util.ArrayList;

public class Category {
	
	private int id;
	private String name;
	private String details;
	private ArrayList<CCA> CCAs;
	
	public Category(int id, String name, String details, ArrayList<CCA> CCAs) {
		this.id = id;
		this.name = name;
		this.details = details;
		this.CCAs = CCAs;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public ArrayList<CCA> getCCAs() {
		return CCAs;
	}

	public void setCCAs(ArrayList<CCA> cCAs) {
		CCAs = cCAs;
	}
	
	
	
	
	
	
	
}
