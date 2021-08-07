import java.util.ArrayList;
import java.util.Random;

public class C206_CaseStudy {

	static ArrayList<StudentList> studentList = new ArrayList<StudentList>();
	static ArrayList<CCA> ccaList = new ArrayList<CCA>();
	static ArrayList<Category> categoryList = new ArrayList<Category>();

	private static final int OPTION_VIEW_STUDENT = 1;
	private static final int OPTION_ADD_STUDENT = 2;
	private static final int OPTION_DELETE_STUDENT = 3;
	private static final int OPTION_VIEW_CCA = 4;
	private static final int OPTION_ADD_CCA = 5;
	private static final int OPTION_DELETE_CCA = 6;
	private static final int OPTION_VIEW_PARENT = 7;
	private static final int OPTION_UPDATE_PARENT = 8;
	private static final int OPTION_DELETE_PARENT = 9;
	private static final int OPTION_QUIT = 20;
////
	public static void main(String args[]) {

		ccaList.add(new CCA(1, "Sports", "Rock climbing,swimming etc", 10, "Monday", 3.00, 5.00, "Field", "Thomas"));
		ccaList.add(new CCA(2, "Music", "Chance to use different instruments", 30, "Wednesday", 3.00, 6.00,
				"Music room", "Willy"));
		ccaList.add(new CCA(3, "Photograph", "Experience to take photographs", 25, "Friday", 2.30, 5.00, "Photo room",
				"Annie"));

		ArrayList<Integer> studentCCA1 = new ArrayList<Integer>();
		ArrayList<Integer> studentCCA2 = new ArrayList<Integer>();
		String[] qna1student1 = {"What is your father's name? ", "James"};
		String[] qna2student1 = {"What is your birth month? ", "August"};
		String[] qna1student2 = {"What is your mother's name? ", "Woman"};
		String[] qna2student2 = {"What is your birth month? ", "July"};
		studentList.add(new StudentList(1, "1", "Amy", "admin"));
		studentList.add(new StudentList(2, "2", "Tom", "member", 1, "James", studentCCA1, qna1student1, qna2student1));
		studentList.add(new StudentList(3, "3", "Sean", "member", 3, "Woman", studentCCA2, qna1student2, qna2student2));

		categoryList.add(new Category(1, "Sports", "Basic physical training", ccaList));
		categoryList.add(new Category(2, "Uniform group", "UG", ccaList));

		boolean loop = true;
		
		while(loop==true) {
			coverMenu();
			int optionCover = Helper.readInt("Enter option: ");
			
			if (optionCover == 2) {
				int studentID = Helper.readInt("Enter student ID to register for CCA: ");
				Random random = new Random();
				String regID = "";
				for (int i = 0; i < 5; i++) {
					regID += "" + random.nextInt(10);
				}
				String password = regID;
				String name = Helper.readString("Enter name: ");
				int primary = Helper.readInt("Enter primary level: ");
				String parentName = Helper.readString("Enter parent name: ");
				String q1 = Helper.readString("Enter security question 1: ");
				String ans1 = Helper.readString("Enter answer for security question 1: ");
				String q2 = Helper.readString("Enter security question 2: ");
				String ans2 = Helper.readString("Enter answer for security question 2: ");
				ArrayList<Integer> studentCCA = new ArrayList<Integer>();
				String alQ1[] = {q1, ans1}; 
				String alQ2[] = {q2, ans2};
				
				if (password.isEmpty() || name.isEmpty() || primary < 1 || primary > 6 || parentName.isEmpty() || q1.isEmpty() || ans1.isEmpty() || q2.isEmpty() || ans2.isEmpty()) {
					System.out.println("Invalid inputs!");
				} else {
					StudentList newStudent = new StudentList(studentID, password, name, "member", primary, parentName,
							studentCCA, alQ1, alQ2);
					addStudent(studentList, newStudent);
				}
				System.out.println("Registration sent to email of student ID\n");
				System.out.println("Registration ID " + password);
				
				
			} else if(optionCover == 3) {
				int studentID = Helper.readInt("Enter studentID: ");
				if(existID(studentID, studentList)) {
					int index = getindexviaID(studentID, studentList);
					String ans1 = Helper.readString(studentList.get(index).getQuestion1()[0]);
					String ans2 = Helper.readString(studentList.get(index).getQuestion2()[0]);
					if((ans1.equalsIgnoreCase(studentList.get(index).getQuestion1()[1]))&&(ans2.equalsIgnoreCase(studentList.get(index).getQuestion2()[1]))) {
						System.out.println("Registration ID has been sent to email of Student ID: " + studentID);
						System.out.println("Registration ID: " + studentList.get(index).getPassword());
					}else {
						System.out.println("Wrong answer");
					}
				}else {
					System.out.println("Student ID is not registered");
				}
				
			} else if(optionCover == 1) {
				loginMenu();

				int userInputID = Helper.readInt("Enter student ID: ");
				String userInputPassword = Helper.readString("Enter your registration ID: ");
				int isLogin = loginCheck(userInputID, userInputPassword);

				while (isLogin == -1) {

					Helper.line(30, "-");
					System.out.println("Incorrect student or registration ID");
					Helper.line(30, "-");
					userInputID = Helper.readInt("Enter your student ID: ");
					userInputPassword = Helper.readString("Enter your registration ID: ");
					isLogin = loginCheck(userInputID, userInputPassword);

				}

				int staffChoice = 1;

				if (!(isLogin == -1)) {
					if (studentList.get(isLogin).getRole().equalsIgnoreCase("admin")) {

						while (staffChoice != OPTION_QUIT) {

							AdminMenuFront();
							staffChoice = Helper.readInt("Enter choice > ");
							int index = 0;
							
							if(staffChoice == 1) {
								AdminMenuStudent();
								staffChoice = Helper.readInt("Enter choice > ");
								
								if(staffChoice == 1) {
									viewAllStudent(studentList);
								}
								else if (staffChoice == 2) {

									String password = Helper.readString("Enter password: ");
									String name = Helper.readString("Enter name: ");
									int primary = Helper.readInt("Enter primary level: ");
									String parentName = Helper.readString("Enter parent name: ");
									ArrayList<Integer> studentCCA = new ArrayList<Integer>();

									StudentList newStudent = new StudentList(studentList.size(), password, name, "member", primary, parentName, studentCCA);
									addStudent(studentList, newStudent);
				
								}
								else if (staffChoice == 3) {
									int studentID = Helper.readInt("Enter Student ID: ");
									deleteStudent(studentList, studentID);
								}
								else if (staffChoice == 4) {

									viewAllParent(studentList);
								}
								else if (staffChoice == 5) {
									
									Helper.line(30, "-");
									System.out.println("UPDATE PARENT");
									Helper.line(30, "-");

									int userID = Helper.readInt("Enter id: ");
									index = 0;
									
									for (int i = 0; i < studentList.size(); i++) {
										if (studentList.get(i).getID() == userID) {
											index = i;
											break;
										}
									}

									String parentName = Helper.readString("Enter Parent Name: ");

									if (parentName.isEmpty()) {
										System.out.println("Empty inputs!");
									} else {
										if (studentList.get(index).getRole() == "member") {
											studentList.get(index).setparentName(parentName);
											System.out.println("Updated Parent name");
										} else {
											System.out.println("Wrong account used!");
										}

									}
								}
								else if(staffChoice == 6) {
									Helper.line(30, "-");
									System.out.println("DELETE CCA");
									Helper.line(30, "-");

									int userID = Helper.readInt("Enter id: ");

									index = 0;
									for (int i = 0; i < studentList.size(); i++) {
										if (studentList.get(i).getID() == userID) {
											index = i;
											break;
										}
									}
									if (studentList.get(index).getRole() == "member") {
										studentList.get(index).setparentName("");
										System.out.println("Deleted Parent name");
									} else {
										System.out.println("Wrong account used!");
									}
								}
								else if(staffChoice == 7) {
									Helper.line(30, "-");
									System.out.println("Update Student Details");
									Helper.line(30, "-");
									
									int userID = Helper.readInt("Enter id: ");
									index = 0;
									for (int i = 0; i < studentList.size(); i++) {
										if (studentList.get(i).getID() == userID) {
											index = i;
											break;
										}
									}

									String name = Helper.readString("Enter Student Name: ");
									int primary = Helper.readInt("Enter student primary: ");

									if (name.isEmpty() || String.valueOf(primary).isEmpty()) {
										System.out.println("Empty inputs!");
									} 
									else {
										studentList.get(index).setName(name);
										studentList.get(index).setPrimary(primary);
										System.out.println("Updated children details");
									}
								}
								else {
									System.out.println("Invalid Option!");
								}
							}
							
							
							else if(staffChoice == 2) {
								AdminMenuCategories();
								staffChoice = Helper.readInt("Enter choice > ");
								
								if(staffChoice == 1) {
									String a = viewCategories(categoryList);
									System.out.println(a);
								}
								else if (staffChoice == 2) {
									int id = categoryList.size() + 1;
									String name = Helper.readString("Enter Category name: ");
									String details = Helper.readString("Enter Category details: ");

									Category category = new Category(id, name, details, ccaList);
									addCategories(categoryList, category);
								}
								else if (staffChoice == 3) {
									int id = Helper.readInt("Enter id: ");
									deleteCategories(categoryList, id);
								}
								else if (staffChoice == 4) {
									int categoryId = Helper.readInt("Enter id of category: ");
									String categoryDetails = Helper.readString("Edit Category details: ");

									String output = C206_CaseStudy.editCategoryDetails(categoryList, categoryDetails, categoryId);
									System.out.println(output);
								}
								else if (staffChoice == 5) {
									int ccaId = Helper.readInt("Enter CCA ID: ");
									String ccaCategory = Helper.readString("Edit CCA category: ");
								}
								else {
									System.out.println("Invalid Option!");
								}
							}
							else if(staffChoice == 3) {
								AdminMenuCCA();
								staffChoice = Helper.readInt("Enter choice > ");
								
								if(staffChoice == 1) {

									viewAllCCA(ccaList);
								}
								else if (staffChoice == 2) {
									
									String title = Helper.readString("Enter CCA title: ");
									String description = Helper.readString("Enter CCA description: ");
									int classSize = Helper.readInt("Enter CCA classSize: ");
									String dayOfTheWeek = Helper.readString("Enter CCA day: ");
									int startTime = Helper.readInt("Enter CCA start time: ");
									int endTime = Helper.readInt("Enter CCA end time: ");
									String venue = Helper.readString("Enter CCA venue: ");
									String instructorName = Helper.readString("Enter CCA instructor name: ");
									
									CCA newCCA = new CCA(ccaList.size(), title, description, classSize, dayOfTheWeek, startTime,
												endTime, venue, instructorName);
									addCCA(ccaList, newCCA);
								}
								else if (staffChoice == 3) {
									int ccaId = Helper.readInt("Enter CCA ID: ");
									C206_CaseStudy.deleteCCA(ccaList, ccaId);
								}
								else if (staffChoice == 4) {
									int ccaId = Helper.readInt("Enter id of CCA: ");
									String ccaDetail = Helper.readString("Edit CCA details: ");

									C206_CaseStudy.editCCADetails(ccaList, ccaDetail, ccaId);
								}
								else if (staffChoice == 5) {
									
									Helper.line(30, "-");
									System.out.println("VIEW STUDENT'S JOINED CCA");
									Helper.line(30, "-");
									String studentName = Helper.readString("Enter student's name: ");
									if (getStudent(studentList, studentName) == -1) {
										System.out.println("Invalid name");
									} else {
										viewStudentCCA(studentList.get(getStudent(studentList, studentName)).getRegisteredCCA(),
												ccaList);
									}

								}
								else if(staffChoice == 6) {
									
									Helper.line(30, "-");
									System.out.println("ADD CCA FOR STUDENT");
									Helper.line(30, "-");
									String studentName = Helper.readString("Enter student's name: ");
									int CCAid = Helper.readInt("Enter ID of CCA to join: ");
									if (getStudent(studentList, studentName) == -1) {
										System.out.println("Invalid name");
									} else {
										if (checkccaID(ccaList, CCAid)) {
											addStudentCCA(studentList.get(getStudent(studentList, studentName)).getRegisteredCCA(),
													CCAid);
										} else {
											System.out.println("Invalid ID");
										}

									}
								}
								else if(staffChoice == 7) {
									
									Helper.line(30, "-");
									System.out.println("DROP CCA FOR STUDENT");
									Helper.line(30, "-");
									String studentName = Helper.readString("Enter student's name: ");
									int CCAid = Helper.readInt("Enter ID of CCA to drop: ");
									if (getStudent(studentList, studentName) == -1) {
										System.out.println("Invalid name");
									} else {
										if (checkccaID(ccaList, CCAid)) {
											dropStudentCCA(studentList.get(getStudent(studentList, studentName)).getRegisteredCCA(),
													CCAid);
										} else {
											System.out.println("Invalid ID");
										}

									}
								}
								else {
									System.out.println("Invalid Option!");
								}
							}
							else {
								System.out.println("Invalid Option Selected");
							}
							
							
						}
					} else if (studentList.get(isLogin).getRole().equalsIgnoreCase("member")) {
						while (staffChoice != OPTION_QUIT) {
							StudentMenu();
							staffChoice = Helper.readInt("Enter choice > ");

							int index = isLogin;

							if (staffChoice == OPTION_VIEW_STUDENT) {
								Helper.line(30, "-");
								System.out.println("VIEW STUDENT");
								Helper.line(30, "-");

								viewStudent(studentList, index);

							} else if (staffChoice == 2) {
								Helper.line(30, "-");
								System.out.println("VIEW CCA");
								Helper.line(30, "-");

								viewAllCCA(ccaList);
							} else if (staffChoice == 3) {
								Helper.line(30, "-");
								System.out.println("VIEW PARENT");
								Helper.line(30, "-");

								retrieveParent(studentList, index);
							} else if (staffChoice == 4) {
								Helper.line(30, "-");
								System.out.println("ADD CCA");
								Helper.line(30, "-");

								int CCAid = Helper.readInt("Enter ID of CCA to join: ");
								if (checkccaID(ccaList, CCAid)) {
									addStudentCCA(studentList.get(isLogin).getRegisteredCCA(), CCAid);
								} else {
									System.out.println("Invalid ID");
								}

							} else if (staffChoice == 5) {
								Helper.line(30, "-");
								System.out.println("DROP CCA");
								Helper.line(30, "-");
								int CCAid = Helper.readInt("Enter ID of CCA to drop: ");
								if (checkccaID(ccaList, CCAid)) {
									dropStudentCCA(studentList.get(isLogin).getRegisteredCCA(), CCAid);
								} else {
									System.out.println("Invalid ID");
								}
							} else if (staffChoice == 6) {
								Helper.line(30, "-");
								System.out.println("VIEW JOINED CCA");
								Helper.line(30, "-");

								viewStudentCCA(studentList.get(isLogin).getRegisteredCCA(), ccaList);
							}
							
							
							// Update Child's details
							else if (staffChoice == 7) {
								Helper.line(30, "-");
								System.out.println("UPDATE CHILD'S DETAILS");
								Helper.line(30, "-");
								
								int userID = Helper.readInt("Enter id: ");
								index = 0;
								for (int i = 0; i < studentList.size(); i++) {
									if (studentList.get(i).getID() == userID) {
										index = i;
										break;
									}
								}

								String name = Helper.readString("Enter Child Name: ");
								String password = Helper.readString("Enter Child password: ");
								int primary = Helper.readInt("Enter Child primary: ");

								if (name.isEmpty() || String.valueOf(primary).isEmpty() || password.isEmpty()) {
									System.out.println("Empty inputs!");
								} 
								else {
									studentList.get(index).setName(name);
									studentList.get(index).setPassword(password);
									studentList.get(index).setPrimary(primary);
									System.out.println("Updated Parent name");
								}
								
							} else if (staffChoice == OPTION_QUIT) {
								System.out.println("Program End");
							} else {
								System.out.println("Invalid choice");
							}
						}
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

	public static void StudentMenu() {
		Helper.line(30, "-");
		System.out.println("STUDENT MENU");
		Helper.line(30, "-");

		System.out.println("1. View Student");
		System.out.println("2. View All CCA");
		System.out.println("3. View Parent");
		System.out.println("4. Add CCA");
		System.out.println("5. Drop CCA");
		System.out.println("6. View Joined CCA");
		System.out.println("20. Quit");

	}
	
	public static void AdminMenuFront() {
		Helper.line(30, "-");
		System.out.println("ADMIN MENU");
		Helper.line(30, "-");
		
		System.out.println("1. STUDENT");
		System.out.println("2. CATEGORIES");
		System.out.println("3. CCA");
		System.out.println("20. Quit");
	}
	
	public static void AdminMenuStudent() {
		Helper.line(30, "-");
		System.out.println("STUDENT / PARENT MENU");
		Helper.line(30, "-");
		
		System.out.println("1. View All Student");
		System.out.println("2. Add Student");
		System.out.println("3. Delete Student");
		System.out.println("4. View All Parent");
		System.out.println("5. Update Parent");
		System.out.println("6. Delete Parent");
		System.out.println("7. Update Student details");
	}
	
	public static void AdminMenuCategories() {
		Helper.line(30, "-");
		System.out.println("CATEGORIES MENU");
		Helper.line(30, "-");
		
		System.out.println("1. View All Categories");
		System.out.println("2. Add Category");
		System.out.println("3. Delete Category");
		System.out.println("4. Edit Category Details");
		System.out.println("5. Update Category Details");
	}
	
	public static void AdminMenuCCA() {
		Helper.line(30, "-");
		System.out.println("CCA MENU");
		Helper.line(30, "-");
		
		System.out.println("1. View All CCA");
		System.out.println("2. Add CCA");
		System.out.println("3. Delete CCA");
		System.out.println("4. Edit CCA details");
		System.out.println("5. View Student's CCA");
		System.out.println("6. Add CCA for Student");
		System.out.println("7. Drop CCA for Student");
		
	}

//	public static void AdminMenu() {
//		Helper.line(30, "-");
//		System.out.println("ADMIN MENU");
//		Helper.line(30, "-");
//
//		System.out.println("1. View All Student");
//		System.out.println("2. Add Student");
//		System.out.println("3. Delete Student");
//		System.out.println("4. View All CCA");
//		System.out.println("5. Add CCA");
//		System.out.println("6. Delete CCA");
//		System.out.println("7. View All Parent");
//		System.out.println("8. Update Parent");
//		System.out.println("9. Delete Parent");
//		System.out.println("10. Add CCA for Student");
//		System.out.println("11. Drop CCA for Student");
//		System.out.println("12. View Student's CCA");
//		System.out.println("13. View all categories");
//		System.out.println("14. Add category");
//		System.out.println("15. Edit Category Details");
//		System.out.println("16. Delete category");
//		System.out.println("17. Edit CCA details");
//		System.out.println("18. Update category details");
//		System.out.println("20. Quit");
//
//	}

	public static void coverMenu() {
		Helper.line(30, "-");
		System.out.println("CCA REGISTRATION MENU");
		Helper.line(30, "-");

		System.out.println("1. Login");
		System.out.println("2. Register");
		System.out.println("3. Forgot Registration ID");
	}

	public static void addStudent(ArrayList<StudentList> studentList, StudentList s) {
		
		Helper.line(30, "-");
		System.out.println("ADD STUDENT");
		Helper.line(30, "-");
		
		if (s.getPassword().isEmpty() || s.getName().isEmpty() || s.getPrimary() < 1 || s.getPrimary() > 6
				|| s.getparentName().isEmpty()) {
			System.out.println("Empty inputs!");
		}
		else {
			studentList.add(s);
			System.out.println("Student " + s.getName() + " is added.");
		}
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

	public static void deleteStudent(ArrayList<StudentList> studentList, int studentID) {
		Helper.line(30, "-");
		System.out.println("DELETE STUDENT");
		Helper.line(30, "-");

		if (studentList.size() != 0) {
			if (Integer.toString(studentID).isEmpty()) {
				System.out.println("Empty inputs");
			} else {
				for (int i = 0; i < studentList.size(); i++) {
					if (studentList.get(i).getID() == studentID) {
						studentList.remove(i);
						System.out.println("Student is deleted successfully");
					}
				}
			}
		} else {
			System.out.println("No student to delete.");
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
				if ((studentList.get(i).getID() == id)
						&& (studentList.get(i).getPassword().equalsIgnoreCase(password))) {
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
		Helper.line(30, "-");
		System.out.println("PARENT LIST");
		Helper.line(30, "-");
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
		
		Helper.line(30, "-");
		System.out.println("ADD CCA");
		Helper.line(30, "-");
		
		if (cc.getTitle().isEmpty() || cc.getdescription().isEmpty() || cc.getDayOfTheWeek().isEmpty() || cc.getVenue().isEmpty()
				|| cc.getInstructorName().isEmpty()) {
			System.out.println("Empty inputs!");
		}
		else {
			ccaList.add(cc);
			System.out.println("CCA have been added");
		}
	}

	public static String retrieveAllCCA(ArrayList<CCA> ccaList) {
		String output = "";

		for (int i = 0; i < ccaList.size(); i++) {

			output += String.format("%-10d %-10s %-35s %-10d %-10s %-10.2f %-10.2f %-15s %-10s\n",
					ccaList.get(i).getCcaId(), ccaList.get(i).getTitle(), ccaList.get(i).getdescription(),
					ccaList.get(i).getClassSize(), ccaList.get(i).getDayOfTheWeek(), ccaList.get(i).getStartTime(),
					ccaList.get(i).getEndTime(), ccaList.get(i).getVenue(), ccaList.get(i).getInstructorName());
		}
		return output;
	}

	public static void viewAllCCA(ArrayList<CCA> ccaList) {
		Helper.line(30, "-");
		System.out.println("VIEW CCA");
		Helper.line(30, "-");
		String output = "===CCA DETAILS===";
		output += String.format("\n%-10s %-10s %-35s %-10s %-10s %-10s %-10s %-15s %-10s\n", "ID", "NAME",
				"DESCRIPTION", "CLASS SIZE", "CCA DAY", "START TIME", "END TIME", "VENUE", "INSTRUCTOR");
		output += retrieveAllCCA(ccaList);
		System.out.println(output);
	}

	public static void deleteCCA(ArrayList<CCA> ccaList, int ccaId) {
		Helper.line(30, "-");
		System.out.println("DELETE CCA");
		Helper.line(30, "-");

		if (ccaId < 1) {
			System.out.println("Empty inputs");
		} else {
			ccaList.remove(ccaId - 1);
			System.out.println("CCA is deleted successfully");
		}
	}
	
	public static String editCCADetails(ArrayList<CCA> ccaList, String ccaDetails, int ccaId) {
		if (String.valueOf(ccaId).isEmpty()) {
			System.out.println("Empty inputs");
		}
			if (ccaList.size() == 0) {
				System.out.println("No CCA to edit.");
			} else {
				for (int i = 0; i < ccaList.size(); i++) {
					CCA c = ccaList.get(i);

					if (c.getCcaId() == ccaId) {
						ccaList.get(i).setdescription(ccaDetails);
						System.out.println("Successfully added");
					}
				}

			}
			return ccaDetails;
		}

	public static void addStudentCCA(ArrayList<Integer> ccalist, int id) {
		boolean check = false;
		if (ccalist.size() != 0) {
			for (int i = 0; i < ccalist.size(); i++) {
				if (ccalist.get(i) == id) {
					check = true;
					break;
				}

			}
			if (check == true) {
				System.out.println("CCA already registered");
			} else {
				ccalist.add(id);
				System.out.println("CCA registered successfully");
			}
		} else {
			ccalist.add(id);
			System.out.println("CCA registered successfully");
		}
	}

	public static void dropStudentCCA(ArrayList<Integer> ccalist, int id) {
		boolean check = false;
		int deleteid = 0;
		if (ccalist.size() != 0) {
			for (int i = 0; i < ccalist.size(); i++) {
				if (ccalist.get(i) == id) {
					check = true;
					deleteid = i;
					break;
				}

			}
			if (check == false) {
				System.out.println("CCA not registered");
			} else {
				ccalist.remove(deleteid);
				System.out.println("CCA dropped successfully");
			}
		} else {
			System.out.println("No CCA registered");
		}
	}

	public static void viewStudentCCA(ArrayList<Integer> ccalist, ArrayList<CCA> ccalist2) {
		String output = "===REGISTERED CCA===";
		if (ccalist.size() != 0) {
			for (int i = 0; i < ccalist.size(); i++) {
				for (int j = 0; j < ccalist2.size(); j++) {
					if (ccalist2.get(j).getCcaId() == ccalist.get(i)) {
						output += String.format("\n   ID:%-2d %s", ccalist2.get(j).getCcaId(),
								ccalist2.get(j).getTitle());
					}
				}
			}
		}

		System.out.println(output);
	}

	public static int getStudent(ArrayList<StudentList> studentlist, String name) {
		int index = -1;
		if (studentlist.size() != 0) {
			for (int i = 0; i < studentlist.size(); i++) {
				if (studentlist.get(i).getName().equalsIgnoreCase(name)) {
					index = i;
					break;
				}
			}
		}
		return index;
	}

	public static boolean checkccaID(ArrayList<CCA> ccalist, int id) {
		boolean result = false;
		if (ccalist.size() != 0) {
			for (int i = 0; i < ccalist.size(); i++) {
				if (ccalist.get(i).getCcaId() == id) {
					result = true;
					break;
				}
			}
		}
		return result;
	}
	
	public static boolean existID(int studentID, ArrayList<StudentList> studentList) {
		boolean result = false;
		for(int i=0; i<studentList.size();i++) {
			if(studentID==studentList.get(i).getID()) {
				result = true;
			}
		}
		return result;
	}
	
	public static int getindexviaID(int studentID, ArrayList<StudentList> studentList) {
		int result = 0;
		for(int i=0; i<studentList.size();i++) {
			if(studentID==studentList.get(i).getID()) {
				result = i;
			}
		}
		return result;
	}

	// STUDENT FUNCTIONS
	// ============================================================

	public static void retrieveParent(ArrayList<StudentList> studentList, int index) {

		String output = String.format("%-15s %-15s\n", "STUDENT NAME", "PARENTS NAME");
		output += String.format("%-15s %-15s\n", studentList.get(index).getName(),
				studentList.get(index).getparentName());

		Helper.line(30, "-");
		System.out.println(output);
		Helper.line(30, "-");

	}

	public static void viewStudent(ArrayList<StudentList> studentList, int index) {
		String output = String.format("%-10s %-20s %-10s %-10s\n", "NAME", "ROLE", "PRIMARY", "PARENT NAME");
		output += String.format("%-10s %-20s %-10s %-10s\n", studentList.get(index).getName(),
				studentList.get(index).getRole(), studentList.get(index).getPrimary(),
				studentList.get(index).getparentName());
		System.out.println(output);
	}

	public static String viewCategories(ArrayList<Category> categoryList) {
		String output = String.format("%-5s %-30s %-30s\n", "ID", "NAME", "DETAILS");

		for (int i = 0; i < categoryList.size(); i++) {
			if (!categoryList.get(i).getName().isEmpty()) {
				output += String.format("%-5d %-30s %-30s\n", categoryList.get(i).getId(),
						categoryList.get(i).getName(), categoryList.get(i).getDetails());
			}
		}
		return output;

	}
	
	public static String editCategoryDetails(ArrayList<Category> categoryList, String categoryDetails, int categoryId) {
		String output = "";
		if (String.valueOf(categoryId).isEmpty()) {
			output = ("Empty inputs");
		}
			if (categoryList.size() == 0) {
				output = ("No Category to edit.");
			} else {
				for (int i = 0; i < categoryList.size(); i++) {
					Category c = categoryList.get(i);

					if (c.getId() == categoryId) {
						categoryList.get(i).setDetails(categoryDetails);
//						categoryList.set(categoryList.get(i).getId(), categoryDetails);
						output = ("Successfully added");
					}
				}

			}
			return output;
		}
	
	

	public static void addCategories(ArrayList<Category> categoryList, Category category) {
		if (category.getName().isEmpty() || category.getDetails().isEmpty()) {
			System.out.println("Empty inputs");
		} else {
			categoryList.add(category);
			System.out.println("Successfully added");
		}
	}

	public static void deleteCategories(ArrayList<Category> categoryList, int id) {
		boolean checker = false;
		for (int i = 0; i < categoryList.size(); i++) {
			if (categoryList.get(i).getId() == id) {
				categoryList.remove((i));
				checker = true;
				break;
			}
		}

		if (checker == false) {
			System.out.println("Invalid id");
		}
	}

}