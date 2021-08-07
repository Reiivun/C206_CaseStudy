import java.util.ArrayList;

/*
 * I declare that this code was written by me. 
 * I will not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: Liau Ke En
 * Student ID: 20027025
 * Class: C208
 * Date/Time created: Saturday 24-07-2021 18:07
 */

public class StudentList {
	private int id;
	private String password;
	private String name;
	private String role;
	private int primary;
	private String parentname;
	private ArrayList<Integer> registeredCCA;
	private String[] question1;
	private String[] question2;
 	

	public StudentList(int id, String password, String name, String role) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.role = role;
	}
	
	public StudentList(int id, String password, String name, String role, int primary, String parentname) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.role = role;
		this.primary = primary;
		this.parentname = parentname;
	}
	
	public StudentList(int id, String password, String name, String role, int primary, String parentname, ArrayList<Integer> registeredCCA) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.role = role;
		this.primary = primary;
		this.parentname = parentname;
		this.registeredCCA = registeredCCA;
	}
	
	public StudentList(int id, String password, String name, String role, int primary, String parentname, ArrayList<Integer> registeredCCA, String[] question1, String[] question2) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.role = role;
		this.primary = primary;
		this.parentname = parentname;
		this.registeredCCA = registeredCCA;
		this.question1 = question1;
		this.question2 = question2;
		
	}
	
	public int getID() {
		return id;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String newPassword) {
		password = newPassword;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrimary() {
		return primary;
	}

	public void setPrimary(int primary) {
		this.primary = primary;
	}
	
	public String getparentName() {
		return parentname;
	}

	public void setparentName(String parentname) {
		this.parentname = parentname;
	}
	
	public String getRole() {
		return role;
	}
	public ArrayList<Integer> getRegisteredCCA() {
		return registeredCCA;
	}

	public void setRegisteredCCA(ArrayList<Integer> registeredCCA) {
		this.registeredCCA = registeredCCA;
	}
	
	public String[] getQuestion1() {
		return question1;
	}

	public void setQuestion1(String[] question1) {
		this.question1 = question1;
	}

	public String[] getQuestion2() {
		return question2;
	}

	public void setQuestion2(String[] question2) {
		this.question2 = question2;
	}
	
}
