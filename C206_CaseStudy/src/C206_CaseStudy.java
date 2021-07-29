
import java.util.ArrayList;

public class C206_CaseStudy {

	static ArrayList<StudentList> studentList = new ArrayList<StudentList>();
	static ArrayList<CCA> ccaList = new ArrayList<CCA>();

	private static final int OPTION_VIEW = 1;

	public static void main(String args[]) {

		ArrayList<StudentList> studentList = new ArrayList<StudentList>();
		ArrayList<CCA> ccaList = new ArrayList<CCA>();

		ccaList.add(new CCA("Sports", "Sports include rock climbing,swimming and many more", 10, "Monday", 3.00, 5.00,
				"Field", "Thomas"));
		ccaList.add(new CCA("Music", "Play instruments like guitar , piano and many more", 30, "Wednesday", 3.00, 6.00,
				"Music room", "Willy"));
		ccaList.add(new CCA("Photography", "Experience to take photographs", 25, "Friday", 2.30, 5.00,
				"Photography room", "Annie"));

		studentList.add(new StudentList(1, "1", "Amy", "admin"));
		studentList.add(new StudentList(2, "2", "Tom", "member", 1, "James"));
		studentList.add(new StudentList(3, "3", "Sean", "member", 3, "Woman"));

		C206_CaseStudy.AdminMenu();
		int staffChoice = Helper.readInt("Enter choice > ");

		if (staffChoice == 1) {
			C206_CaseStudy.viewAllStudent(studentList);
			
		} else if (staffChoice == 2) {
			

		} else if (staffChoice == 3) {

		} else if (staffChoice == 4) {

		} else if (staffChoice == 5) {

		} else if (staffChoice == 6) {

		} else if (staffChoice == 7) {

		} else if (staffChoice == 8) {

		} else if (staffChoice == 9) {

		} else if (staffChoice == 10) {
			System.out.println("Program End");
		} else {
			System.out.println("Invalid choice");
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
		System.out.println("8. Add Parent");
		System.out.println("9. Delete Parent");
		System.out.println("10. Quit");

	}

	public static void addStudent(ArrayList<StudentList> studentList, StudentList s) {
		studentList.add(s);
		System.out.println("Student " + s + " is added.");
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

	public static void deleteStudent(ArrayList<StudentList> studentList, StudentList s) {
		if (studentList.size() != 0) {
			for (int i = 0; i < studentList.size(); i++) {
				if (studentList.get(i) == s) {
					if (studentList.get(i).getRole() == "member") {
						studentList.remove(s);
						System.out.println("Student " + s + " is deleted.");
					}
				} else {
					System.out.println("Input does not match any of the students in the list.");
				}
			}
		} else {
			System.out.println("No students in list to delete.");
		}

	}

	public static void ccaDisplay() {
		for (int i = 0; i < ccaList.size(); i++) {
			if (!(ccaList.get(i).getTitle().isEmpty())) {
				System.out.println((i + 1) + ". " + ccaList.get(i).getTitle());
			}
		}
	}

	public static boolean loginCheck(int id, String password) {
		boolean isChecked = false;
		for (int i = 0; i < studentList.size(); i++) {
			if (!(studentList.get(i).getName().isEmpty())) {
				if ((studentList.get(i).getID() == id)
						&& (studentList.get(i).getPassword().equalsIgnoreCase(password))) {
					isChecked = true;
					break;
				}
			}
		}
		return isChecked;
	}

	// Parents
	public static String retrieveAllParent(ArrayList<StudentList> studentList) {
		String output = "";
		if (studentList.size() != 0) {
			for (int i = 0; i < studentList.size(); i++) {
				if (studentList.get(i).getRole() == "member") {
					output += String.format("%-10s %-20d\n", studentList.get(i).getName(),
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
		String output = String.format("%-10s %-20s\n", "NAME", "PARENTS NAME");
		output += retrieveAllParent(studentList);
		System.out.println(output);
	}

	public static void addParent(ArrayList<StudentList> studentList, StudentList s) {
		studentList.add(s);
		System.out.println("Parent " + s + " is added.");
	}

	public static void deleteParent(ArrayList<StudentList> studentList, StudentList s) {
		if (studentList.size() != 0) {
			for (int i = 0; i < studentList.size(); i++) {
				if (studentList.get(i) == s) {
					if (studentList.get(i).getRole() == "member") {
						studentList.remove(s);
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

			output += String.format("%-10s %-30s %-10d %-10s %-20d %-20d %-10s %-10s\n", ccaList.get(i).getTitle(),
					ccaList.get(i).getdescription(), ccaList.get(i).getClassSize(), ccaList.get(i).getDayOfTheWeek(),
					ccaList.get(i).getStartTime(), ccaList.get(i).getEndTime(), ccaList.get(i).getVenue(),
					ccaList.get(i).getInstructorName());
		}
		return output;
	}

	public static void viewAllCCA(ArrayList<CCA> ccaList) {
		String output = "===CCA DETAILS===";
		output += String.format("%-10s %-30s %-10d %-10s %-20d %-20d %-10s %-10s\n", "NAME", "DESCRIPTION",
				"CLASS SIZE", "CCA DAY", "START TIME", "END TIME", "VENUE", "INSTRUCTOR");
		output += retrieveAllCCA(ccaList);
		System.out.println(output);
	}

	public static void deleteCCA(ArrayList<CCA> ccaList, CCA cc) {
		ccaList.remove(cc);
		System.out.println("The CCA " + cc + " is successfully deleted.");
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