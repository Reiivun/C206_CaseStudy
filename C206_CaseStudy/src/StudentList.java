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
	private int primary;
	
	public StudentList(int id, String password, String name, int primary) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.primary = primary;
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
	
}