
import java.util.ArrayList;

public class C206_CaseStudy {

	static ArrayList<StudentList> studentList = new ArrayList<StudentList>();
	static ArrayList<CCA> ccaList = new ArrayList<CCA>();

	private static final int OPTION_VIEW_STUDENT = 1;
	private static final int OPTION_ADD_STUDENT = 2;
	private static final int OPTION_DELETE_STUDENT = 3;
	private static final int OPTION_VIEW_CCA = 4;
	private static final int OPTION_ADD_CCA = 5;
	private static final int OPTION_DELETE_CCA = 6;
	private static final int OPTION_VIEW_PARENT = 7;
	private static final int OPTION_UPDATE_PARENT = 8;
	private static final int OPTION_DELETE_PARENT = 9;
	private static final int OPTION_QUIT= 10;

	public static void main(String args[]) {


		ccaList.add(new CCA(1,"Sports", "Rock climbing,swimming etc", 10, "Monday", 3.00, 5.00,
				"Field", "Thomas"));
		ccaList.add(new CCA(2,"Music", "Chance to use different instruments", 30, "Wednesday", 3.00, 6.00,
				"Music room", "Willy"));
		ccaList.add(new CCA(3,"Photograph", "Experience to take photographs", 25, "Friday", 2.30, 5.00,
				"Photo room", "Annie"));

		studentList.add(new StudentList(1, "1", "Amy", "admin"));
		studentList.add(new StudentList(2, "2", "Tom", "member", 1, "James"));
		studentList.add(new StudentList(3, "3", "Sean", "member", 3, "Woman"));
		
		
		int userInputID = Helper.readInt("Enter your ID: ");
		String userInputPassword = Helper.readString("Enter your password: ");
		int isLogin = loginCheck(userInputID, userInputPassword);
		
		while(isLogin == -1) {
			
			Helper.line(30, "-");
			System.out.println("Incorrect id or password");
			Helper.line(30, "-");
			userInputID = Helper.readInt("Enter your ID: ");
			userInputPassword = Helper.readString("Enter your password: ");
			isLogin = loginCheck(userInputID, userInputPassword);
			
		}
		
		
		int staffChoice = 1;
		
		if(!(isLogin == -1)) {
			if(studentList.get(isLogin).getRole().equalsIgnoreCase("admin")) {
				
				while(staffChoice != OPTION_QUIT) {
					
					AdminMenu();
					staffChoice = Helper.readInt("Enter choice > ");
					
					if (staffChoice == OPTION_VIEW_STUDENT) {
						viewAllStudent(studentList);
						
					} 
					else if (staffChoice == OPTION_ADD_STUDENT) {
						Helper.line(30, "-");
						System.out.println("ADD STUDENT");
						Helper.line(30, "-");
						
						String password = Helper.readString("Enter password: ");
						String name = Helper.readString("Enter name: ");
						int primary = Helper.readInt("Enter primary level: ");
						String parentName = Helper.readString("Enter parent name: ");
						
						if(password.isEmpty() || name.isEmpty() || primary < 1 || primary > 6 || parentName.isEmpty()) {
							System.out.println("Empty inputs!");
						}
						else {
							StudentList newStudent = new StudentList(studentList.size(), password, name, "member", primary, parentName);
							addStudent(studentList, newStudent);
						}

					} 
					else if (staffChoice == OPTION_DELETE_STUDENT) {
						C206_CaseStudy.deleteStudent(studentList);

					}
					else if (staffChoice == OPTION_VIEW_CCA) {
						Helper.line(30, "-");
						System.out.println("VIEW CCA");
						Helper.line(30, "-");
						
						viewAllCCA(ccaList);
						
					} 
					else if (staffChoice == OPTION_ADD_CCA) {
						
						Helper.line(30, "-");
						System.out.println("ADD CCA");
						Helper.line(30, "-");
						
						String title = Helper.readString("Enter CCA title: ");
						String description = Helper.readString("Enter CCA description: ");
						int classSize = Helper.readInt("Enter CCA classSize: ");
						String dayOfTheWeek = Helper.readString("Enter CCA day: ");
						int startTime = Helper.readInt("Enter CCA start time: ");
						int endTime = Helper.readInt("Enter CCA end time: ");
						String venue = Helper.readString("Enter CCA venue: ");
						String instructorName = Helper.readString("Enter CCA instructor name: ");
						
						if(title.isEmpty() || description.isEmpty() || dayOfTheWeek.isEmpty() || venue.isEmpty() || instructorName.isEmpty()) {
							System.out.println("Empty inputs!");
						}
						
						else {
							CCA newCCA = new CCA(ccaList.size(),title, description, classSize, dayOfTheWeek, startTime, endTime, venue, instructorName);
							addCCA(ccaList, newCCA);
						}
					
					} 
					else if (staffChoice == OPTION_DELETE_CCA) {
						C206_CaseStudy.deleteCCA(ccaList);
						
					} 
					else if (staffChoice == OPTION_VIEW_PARENT) {
						Helper.line(30, "-");
						System.out.println("VIEW PARENT");
						Helper.line(30, "-");
						
						viewAllParent(studentList);
					} 
					else if (staffChoice == OPTION_UPDATE_PARENT) {
						
						Helper.line(30, "-");
						System.out.println("UPDATE PARENT");
						Helper.line(30, "-");
						
						int userID = Helper.readInt("Enter id: ");
						int index = 0;
						for(int i = 0; i < studentList.size(); i++) {
							if(studentList.get(i).getID() == userID) {
								index = i;
								break;
							}
						}
						
						String parentName = Helper.readString("Enter Parent Name: ");
						
						if(parentName.isEmpty()) {
							System.out.println("Empty inputs!");
						}
						else {
							if(studentList.get(index).getRole()=="member") {
								studentList.get(index).setparentName(parentName);
								System.out.println("Updated Parent name");
							}
							else {
								System.out.println("Wrong account used!");
							}
						
						}
						

					} 
					else if (staffChoice == OPTION_DELETE_PARENT) {
						Helper.line(30, "-");
						System.out.println("DELETE CCA");
						Helper.line(30, "-");
						
						int parentID = Helper.readInt("Enter id: ");
						
						if (parentID<1) {
							System.out.println("Invalid id");
						}
						else {
							int index = 0;
							for(int i=0;i<studentList.size();i++) {
								if(studentList.get(i).getID()==parentID) {
									studentList.get(i).setparentName("");
								}
							}	
						}
					} 
					else if (staffChoice == OPTION_QUIT) {
						System.out.println("Program End");
					} 
					else {
						System.out.println("Invalid choice");
					}
				}
			}
		}

	}

	// ALL METHODS BELOW FROM HERE

	public static void loginMenu() {
		Helper.line(30, "-");
		System.out.println("LOGIN");
		Helper.line(30, "-");
	}

	public static void AdminMenu() {
		Helper.line(30, "-");
		System.out.println("ADMIN MENU");
		Helper.line(30, "-");

		System.out.println("1. View All Student");
		System.out.println("2. Add Student");
		System.out.println("3. Delete Student");
		System.out.println("4. View All CCA");
		System.out.println("5. Add CCA");
		System.out.println("6. Delete CCA");
		System.out.println("7. View All Parent");
		System.out.println("8. Update Parent");
		System.out.println("9. Delete Parent");
		System.out.println("10. Quit");

	}

	public static void addStudent(ArrayList<StudentList> studentList, StudentList s) {
		studentList.add(s);
		System.out.println("Student " + s.getName() + " is added.");
	}

	public static void viewAllStudent(ArrayList<StudentList> studentList) {
		Helper.line(30, "-");
		System.out.println("STUDENT LIST");
		Helper.line(30, "-");
		String output = String.format("%-10s %-20s\n", "NAME", "PRIMARY");
		output += retrieveAllStudent(studentList);
		System.out.println(output);
	}

	public static String retrieveAllStudent(ArrayList<StudentList> studentList) {
		String output = "";
		if (studentList.size() != 0) {
			for (int i = 0; i < studentList.size(); i++) {
				if (studentList.get(i).getRole() == "member") {
					output += String.format("%-10s %-20d\n", studentList.get(i).getName(),
							studentList.get(i).getPrimary());
				}
			}
		} else {
			System.out.println("No students in list.");
		}
		return output;
	}

	public static void deleteStudent(ArrayList<StudentList> studentList) {
		Helper.line(30, "-");
		System.out.println("DELETE STUDENT");
		Helper.line(30, "-");
		
		int studentID = Helper.readInt("Enter Student ID: ");
		
		if(studentID<1) {
			System.out.println("Empty inputs");
		}
		else {
			studentList.remove(studentID);
			System.out.println("Student is deleted successfully");
		}

	}

	public static void ccaDisplay() {
		for (int i = 0; i < ccaList.size(); i++) {
			if (!(ccaList.get(i).getTitle().isEmpty())) {
				System.out.println((i + 1) + ". " + ccaList.get(i).getTitle());
			}
		}
	}

	public static int loginCheck(int id, String password) {
		int indexID = -1;
		for (int i = 0; i < studentList.size(); i++) {
			if (!(studentList.get(i).getName().isEmpty())) {
				if ((studentList.get(i).getID()==id) && (studentList.get(i).getPassword().equalsIgnoreCase(password))) {
					indexID = i;
					break;
				}
			}
		}
		return indexID;
	}

	// Parents
	public static String retrieveAllParent(ArrayList<StudentList> studentList) {
		String output = "";
		if (studentList.size() != 0) {
			for (int i = 0; i < studentList.size(); i++) {
				if (studentList.get(i).getRole() == "member") {
					output += String.format("%-15s %-15s\n", studentList.get(i).getName(),
							studentList.get(i).getparentName());
				}
			}
		} else {
			System.out.println("No parents in list.");
		}
		return output;
	}

	public static void viewAllParent(ArrayList<StudentList> studentList) {
		System.out.println("PARENT LIST");
		String output = String.format("%-15s %-15s\n", "STUDENT NAME", "PARENTS NAME");
		output += retrieveAllParent(studentList);
		System.out.println(output);
	}

//	public static void updateParent(ArrayList<StudentList> studentList, StudentList s, int index) {
//	
//		studentList.set(index, s);
//		System.out.println("Parent " + s + " is updated.");
//	}

	public static void deleteParent(ArrayList<StudentList> studentList, StudentList s) {
		if (studentList.size() != 0) {
			for (int i = 0; i < studentList.size(); i++) {
				if (studentList.get(i) == s) {
					if (studentList.get(i).getRole() == "member") {
						studentList.get(i).setparentName("");
						System.out.println("Parent " + s + " is deleted.");
					}

				} else {
					System.out.println("Input does not match any of the parents in the list.");
				}
			}
		} else {
			System.out.println("No parents in list to delete.");
		}
	}

	// CCA DETAILS
	public static void addCCA(ArrayList<CCA> ccaList, CCA cc) {

		ccaList.add(cc);
		System.out.println("CCA have been added");
	}

	public static String retrieveAllCCA(ArrayList<CCA> ccaList) {
		String output = "";

		for (int i = 0; i < ccaList.size(); i++) {

			output += String.format("%-10d %-10s %-35s %-10d %-10s %-10.2f %-10.2f %-15s %-10s\n", ccaList.get(i).getCcaId(), ccaList.get(i).getTitle(),
					ccaList.get(i).getdescription(), ccaList.get(i).getClassSize(), ccaList.get(i).getDayOfTheWeek(),
					ccaList.get(i).getStartTime(), ccaList.get(i).getEndTime(), ccaList.get(i).getVenue(),
					ccaList.get(i).getInstructorName());
		}
		return output;
	}

	public static void viewAllCCA(ArrayList<CCA> ccaList) {
		String output = "===CCA DETAILS===";
		output += String.format("\n%-10s %-10s %-35s %-10s %-10s %-10s %-10s %-15s %-10s\n","ID", "NAME", "DESCRIPTION",
				"CLASS SIZE", "CCA DAY", "START TIME", "END TIME", "VENUE", "INSTRUCTOR");
		output += retrieveAllCCA(ccaList);
		System.out.println(output);
	}

	public static void deleteCCA(ArrayList<CCA> ccaList) {
		Helper.line(30, "-");
		System.out.println("DELETE CCA");
		Helper.line(30, "-");
		
		int ccaId = Helper.readInt("Enter CCA ID: ");
		
		if(ccaId<1) {
			System.out.println("Empty inputs");
		}
		else {
			ccaList.remove(ccaId-1);
			System.out.println("CCA is deleted successfully");
		}
	}

	public static ArrayList<String> addStudentCCA(String name, String cca) {
		// assuming already logged in
		// creating available CCA array for student
		ArrayList<String> studentCCAlist = new ArrayList<String>();
		studentCCAlist.set(0, name);
		if (ccaList.size() != 0) {
			for (int i = 0; i < ccaList.size(); i++) {
				if (ccaList.get(i).getTitle().equalsIgnoreCase(name)) {
					studentCCAlist.add(ccaList.get(i).getTitle());
					break;
				}
			}
		}

		return studentCCAlist;
	}

	public static ArrayList<String> dropStudentCCA(ArrayList<String> studentCCAlist, String cca) {
		// assuming already logged in
		if (studentCCAlist.size() != 0) {
			// index 0 is student name
			for (int i = 1; i < studentCCAlist.size(); i++) {
				if (studentCCAlist.get(i).equalsIgnoreCase(cca)) {
					studentCCAlist.remove(i);
					break;
				}
			}
		}
		return studentCCAlist;

	}
}