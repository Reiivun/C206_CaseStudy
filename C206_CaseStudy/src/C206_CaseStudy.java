import java.util.ArrayList;

public class C206_CaseStudy {
	public static void main(String args[]) {

		ArrayList<StudentList> studentList = new ArrayList<StudentList>();

		studentList.add(new StudentList("Amy", 1));
		studentList.add(new StudentList("Tom", 4));
		studentList.add(new StudentList("Sean", 2));

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
		studentList.remove(s);
		System.out.println("Student " + s + " is deleted.");
	}
}
