import java.util.ArrayList;

public class C206_CaseStudy {
	
	static ArrayList<StudentList> studentList = new ArrayList<StudentList>();
	static ArrayList<CCA> ccaList = new ArrayList<CCA>();
	
	
	public static void main(String args[]) {

		

		studentList.add(new StudentList(1, "1", "Amy", 1));
		studentList.add(new StudentList(2, "2", "Tom", 4));
		studentList.add(new StudentList(3,"3","Sean", 2));

	}

	public static String retrieveAllStudent(ArrayList<StudentList> studentList) {
		String output = "";
		if (studentList.size() != 0) {
			for (int i = 0; i < studentList.size(); i++) {

				output += String.format("%-10s %-20d\n", studentList.get(i).getName(), studentList.get(i).getPrimary());
			}
		} else {
			System.out.println("No students in list.");
		}
		return output;
	}

	public static void viewAllStudent(ArrayList<StudentList> studentList) {
		System.out.println("STUDENT LIST");
		String output = String.format("%-10s %-20s\n", "NAME", "PRIMARY");
		output += retrieveAllStudent(studentList);
		System.out.println(output);

	}

	public static void addStudent(ArrayList<StudentList> studentList, StudentList s) {
		studentList.add(s);
		System.out.println("Student " + s + " is added.");
	}
	
	public static void deleteStudent(ArrayList<StudentList> studentList, StudentList s) {
		if (studentList.size() != 0) {
			for (int i = 0; i < studentList.size(); i++) {
				if (studentList.get(i) != s) {
					System.out.println("No students in list to delete.");
				}
			}
		} else {
			studentList.remove(s);
			System.out.println("Student " + s + " is deleted.");
		}
		
	}
	
	public static void ccaDisplay() {
		for(int i = 0; i < ccaList.size(); i++) {
			if(!(ccaList.get(i).getTitle().isEmpty())) {
				System.out.println((i+1) + ". " + ccaList.get(i).getTitle());
			}
		}
	}
	
	public static boolean loginCheck(int id, String password) {
		boolean isChecked = false;
		for(int i = 0; i < studentList.size(); i++) {
			if(!(studentList.get(i).getName().isEmpty())) {
				if((studentList.get(i).getID() == id) && (studentList.get(i).getPassword().equalsIgnoreCase(password))) {
					isChecked = true;
					break;
				}
			}
		}
		return isChecked;
	}
}
