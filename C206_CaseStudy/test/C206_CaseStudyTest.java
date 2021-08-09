import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	private StudentList sl1;
	private StudentList sl2;
	private StudentList sl3;
	private StudentList sl4;
	private CCA cc1;
	private CCA cc2;
	private CCA cc3;
	private Category ccc1;
	private Category ccc2;

	private ArrayList<StudentList> studentList;
	private ArrayList<CCA> ccaList;
	private ArrayList<Category> categoryList;
	
	public C206_CaseStudyTest() {
		super();
	}
////
	@Before
	public void setUp() throws Exception {
		ArrayList<Integer> studentCCA1 = new ArrayList<Integer>();
		ArrayList<Integer> studentCCA2 = new ArrayList<Integer>();
		sl1 = new StudentList(1, "1", "Amy", "admin"); 
		sl2 = new StudentList(2, "2", "Tom", "member", 1, "James", studentCCA1);
		sl3 = new StudentList(3, "3", "Sean", "member", 3, "Woman", studentCCA2);
		sl4 = new StudentList(2, "2", "Tom", "member", 1, "", studentCCA1);
		
		cc1 = new CCA(1,"Sports", "Rock climbing,swimming etc", 10, "Monday", 3.00, 5.00,
				"Field", "Thomas");
		cc2 = new CCA(2,"Music", "Chance to use different instruments", 30, "Wednesday", 3.00, 6.00,
				"Music room", "Willy");
		cc3 = new CCA(3,"Photograph", "Experience to take photographs", 25, "Friday", 2.30, 5.00,
				"Photo room", "Annie");
		
		ccc1 = new Category(1, "Sports", "Basic physical training", ccaList);
		ccc2 = new Category(2, "Uniform group", "UG", ccaList);
		
		studentList= new ArrayList<StudentList>();
		ccaList= new ArrayList<CCA>();
		categoryList = new ArrayList<Category>();


	}

	// Add Student Test
	@Test
	public void addStudentTest() {
		// Student list is not null, so that can add a new item - boundary
		assertNotNull("Check if there is valid student arraylist to add to", studentList);
		//Given an empty list, after adding 1 student, the size of the list is 1 - normal
		//The item just added is as same as the first student of the list
		C206_CaseStudy.addStudent(studentList, sl2);
		assertEquals("Check that Student arraylist size is 1", 1, studentList.size());
		assertSame("Check that student is added", sl2, studentList.get(0));
		
		//Add another item. test The size of the list is 2? -normal
		//The item just added is as same as the second item of the list
		C206_CaseStudy.addStudent(studentList, sl3);
		assertEquals("Check that Student arraylist size is 2", 2, studentList.size());
		assertSame("Check that student is added", sl3, studentList.get(1));
	}
	
	// Delete Student Test
	@Test
	public void deleteStudentTest() {
		// Student list is not null, so that can add a new item - boundary
		assertNotNull("Check if there is valid student arraylist to add to", studentList);
		
		C206_CaseStudy.addStudent(studentList, sl2);
		assertEquals("Check that Student arraylist size is 1", 1, studentList.size());
		assertSame("Check that student is added", sl2, studentList.get(0));
		
		C206_CaseStudy.addStudent(studentList, sl3);
		assertEquals("Check that Student arraylist size is 2", 2, studentList.size());
		assertSame("Check that student is added", sl3, studentList.get(1));
		
		C206_CaseStudy.deleteStudent(studentList, sl3.getID());
		assertEquals("Check that Student arraylist size is 1", 1, studentList.size());
		assertSame("Check that student is deleted", sl2, studentList.get(0));
		
	}
	
	// Update Student test
	@Test
	public void updateStudentTest() {
		// Test if parent list is not null but empty -boundary
		assertNotNull("Test if there is valid student arraylist to retrieve students", studentList);

		C206_CaseStudy.addStudent(studentList, sl2);
		assertEquals("Check that Student arraylist size is 1", 1, studentList.size());
		assertSame("Check that student is added", sl2, studentList.get(0));
		
		 C206_CaseStudy.updateStudentDetails(studentList, "Tom", "hello", 4);
		String testOutput = "Successfully added";
		
		assertEquals("Test that viewAllParent", studentList);
		
	}
	
	//Add CCA test
	@Test
	public void addCCATest() {
		// CCA list is not null, so that can add a new item - boundary
		assertNotNull("Test if there is valid cca arraylist to add to", ccaList);
		
		//Given an empty list, after adding 1 cca, the size of the list is 1 - normal
		//The cca just added is as same as the first cca of the list
		C206_CaseStudy.addCCA(ccaList, cc1);		
		assertEquals("Test that CCA arraylist size is 1", 1, ccaList.size());
		assertSame("Test that CCA is added", cc1, ccaList.get(0));
		
		//Add another cca. test The size of the list is 2? - normal
		//The cca just added is as same as the second cca of the list
		C206_CaseStudy.addCCA(ccaList, cc2);
		assertEquals("Test that CCA arraylist size is 2", 2, ccaList.size());
		assertSame("Test that CCA is added", cc2, ccaList.get(1));
	}
	
	//Retrieve all student
	@Test
	public void retrieveAllStudentTest() {
		// Test if student list is not null but empty -boundary
		assertNotNull("Test if there is valid student arraylist to retrieve students", studentList);
		
		//test if the list of student retrieved from the SourceCentre is empty - boundary
		String allStudent= C206_CaseStudy.retrieveAllStudent(studentList);
		String testOutput = "";
		assertEquals("Check that viewAllStudent", testOutput, allStudent);
		
		//Given an empty list, after adding 2 items, test if the size of the list is 2 - normal
		C206_CaseStudy.addStudent(studentList, sl2);
		C206_CaseStudy.addStudent(studentList, sl3);
		assertEquals("Test that Student arraylist size is 2", 2, studentList.size());
		
		//test if the expected output string same as the list of student retrieved from the SourceCentre	
		allStudent= C206_CaseStudy.retrieveAllStudent(studentList);
		testOutput = String.format("%-10s %-20d\n", "Tom", 1);
		testOutput += String.format("%-10s %-20d\n", "Sean", 3);
	
		assertEquals("Test that viewAllStudent", testOutput, allStudent);
		
	}
	//Retrieve all cca
	@Test
	public void retrieveAllCCATest() {
		// Test if cca list is not null but empty -boundary
		assertNotNull("Test if there is cca student arraylist to retrieve cca's", ccaList);
		
		//test if the list of student retrieved from the SourceCentre is empty - boundary
		String allCCA= C206_CaseStudy.retrieveAllCCA(ccaList);
		String testOutput = "";
		assertEquals("Check that viewAllCCA", testOutput, allCCA);
		
		//Given an empty list, after adding 2 items, test if the size of the list is 2 - normal
		C206_CaseStudy.addCCA(ccaList, cc1);
		C206_CaseStudy.addCCA(ccaList, cc2);
		assertEquals("Test that cca arraylist size is 2", 2, ccaList.size());
		
		//test if the expected output string same as the list of student retrieved from the SourceCentre	
		allCCA= C206_CaseStudy.retrieveAllCCA(ccaList);
		testOutput = String.format("%-10d %-10s %-35s %-10d %-10s %-10.2f %-10.2f %-15s %-10s\n", 1, "Sports", "Rock climbing,swimming etc", 10, "Monday",3.00, 5.00,
				"Field", "Thomas");

		testOutput += String.format("%-10s %-30s %-10s %-10s %-20s %-20.2f %-20.2f %-10s %-10s  \n","2", "Music", "Yes", "", "Wednesday",3.00, 6.00,
				"Music Room", "Willy");

		testOutput += String.format("%-10d %-10s %-35s %-10d %-10s %-10.2f %-10.2f %-15s %-10s\n", 2, "Music", "Chance to use different instruments", 30, "Wednesday",3.00, 6.00,
				"Music room", "Willy");

		
	}
	
	//Add/Drop CCA for Student
	@Test
	public void adddropStudentCCA() {
		//Test that only existing CCAs can be added
		assertFalse("Test that no such ID exists in CCA array", C206_CaseStudy.checkccaID(ccaList, 1));
		
		//Test that the CCA will be successfully added to the student's database
		studentList.add(sl2);
		ArrayList<Integer> templist = studentList.get(0).getRegisteredCCA();
		C206_CaseStudy.addStudentCCA(templist, 1);
		assertEquals("Test that id 1 is added into cca array for student", 1, studentList.get(0).getRegisteredCCA().size());
		
		//Test that only 1 added at a time
		assertEquals(templist.size(), 1);
		
		//Test that the CCA will be successfully removed from the student's database
		C206_CaseStudy.dropStudentCCA(templist, 1);
		assertEquals("Test that id 1 is removed from cca array for student", 0, studentList.get(0).getRegisteredCCA().size());
		
		//Test that only 1 dropped at a time
		assertTrue(templist.isEmpty());
		
	}
	
	
	
	//Retrieve all Parent
		@Test
		public void retrieveAllParentTest() {
			// Test if parent list is not null but empty -boundary
			assertNotNull("Test if there is valid parent arraylist to retrieve students", studentList);
			
			//test if the list of student retrieved from the SourceCentre is empty - boundary
			String allParent= C206_CaseStudy.retrieveAllStudent(studentList);
			String testOutput = "";
			assertEquals("Check that viewAllParent", testOutput, allParent);
			
			//Given an empty list, after adding 2 items, test if the size of the list is 2 - normal
			C206_CaseStudy.addStudent(studentList, sl2);
			C206_CaseStudy.addStudent(studentList, sl3);
			assertEquals("Test that Student arraylist size is 2", 2, studentList.size());
			
			//test if the expected output string same as the list of student retrieved from the SourceCentre	
			allParent= C206_CaseStudy.retrieveAllParent(studentList);
			testOutput = String.format("%-15s %-15s\n", "Tom", "James");
			testOutput += String.format("%-15s %-15s\n", "Sean", "Woman");
		
			assertEquals("Test that viewAllParent", testOutput, allParent);
			
		}
		
	//Delete Parent Test
		@Test
		public void deleteParentTest() {
			// Student list is not null, so that can add a new item - boundary
			assertNotNull("Check if there is valid student arraylist to add to", studentList);
			
			C206_CaseStudy.addStudent(studentList, sl3);
			assertEquals("Check that Student arraylist size is 2", 1, studentList.size());
			assertSame("Check that student is added", sl3, studentList.get(0));
			
			C206_CaseStudy.deleteParent(studentList, sl3);
			assertSame("Check that parent is deleted", "", sl3.getparentName());
		}
		
		@Test
		public void deleteCCATest() {
			// Student list is not null, so that can add a new item - boundary
			assertNotNull("Check if there is valid student arraylist to delete to", ccaList);
			
			C206_CaseStudy.addCCA(ccaList, cc1);
			assertEquals("Check that CCA arraylist size is 1", 1, ccaList.size());
			assertSame("Check that CCA is added", cc1, ccaList.get(0));
			
			C206_CaseStudy.addCCA(ccaList, cc2);
			assertEquals("Check that CCA arraylist size is 2", 2, ccaList.size());
			assertSame("Check that CCA is added", cc2, ccaList.get(1));
			
			C206_CaseStudy.deleteCCA(ccaList, cc2.getCcaId());
			assertEquals("Check that CCA arraylist size is 1", 1, ccaList.size());
			assertSame("Check that CCA is deleted", cc1, ccaList.get(0));
			
		}
		
		@Test
		public void addCategoryTest() {
			// Student list is not null, so that can add a new item - boundary
			assertNotNull("Check if there is valid student arraylist to add to", categoryList);
			
			C206_CaseStudy.addCategories(categoryList, ccc1);
			assertEquals("Check that category arraylist size is 1", 1, categoryList.size());
			assertSame("Check that category is added", ccc1, categoryList.get(0));
			
			C206_CaseStudy.addCategories(categoryList, ccc2);
			assertEquals("Check that category arraylist size is 1", 2, categoryList.size());
			assertSame("Check that category is added", ccc2, categoryList.get(1));
			
		}
		
		@Test
		public void deleteCategoryTest() {
			// Student list is not null, so that can add a new item - boundary
			assertNotNull("Check if there is valid student arraylist to delete to", ccaList);
			
			C206_CaseStudy.addCategories(categoryList, ccc1);
			assertEquals("Check that category arraylist size is 1", 1, categoryList.size());
			assertSame("Check that category is added", ccc1, categoryList.get(0));
			
			C206_CaseStudy.addCategories(categoryList, ccc2);
			assertEquals("Check that category arraylist size is 1", 2, categoryList.size());
			assertSame("Check that category is added", ccc2, categoryList.get(1));
			
			C206_CaseStudy.deleteCategories(categoryList, ccc2.getId());
			assertEquals("Check that category arraylist size is 1", 1, categoryList.size());
			assertSame("Check that category is deleted", ccc1, categoryList.get(0));
		}
		
		@Test
		public void retrieveCategoriesTest() {
			// Test if parent list is not null but empty -boundary
			assertNotNull("Test if there is valid parent arraylist to retrieve students", categoryList);
			
			//Given an empty list, after adding 2 items, test if the size of the list is 2 - normal
			C206_CaseStudy.addCategories(categoryList, ccc1);
			C206_CaseStudy.addCategories(categoryList, ccc2);
			assertEquals("Test that Category arraylist size is 2", 2, categoryList.size());
			
			//test if the expected output string same as the list of student retrieved from the SourceCentre	
			String allCategory= C206_CaseStudy.viewCategories(categoryList);
			String testoutput = String.format("%-5s %-30s %-30s\n", "ID", "NAME", "DETAILS");
			testoutput += String.format("%-5d %-30s %-30s\n", 1, "Sports", "Basic physical training");
			testoutput += String.format("%-5d %-30s %-30s\n", 2, "Uniform group", "UG");
		
			assertEquals("Test that viewAllParent", testoutput, allCategory);
			
		}
		
		@Test
		public void editCategoryDetailsTest() {
			// Test if parent list is not null but empty -boundary
			assertNotNull("Test if there is valid parent arraylist to retrieve students", categoryList);
			
			//Given an empty list, after adding 2 items, test if the size of the list is 2 - normal
			C206_CaseStudy.addCategories(categoryList, ccc1);
			C206_CaseStudy.addCategories(categoryList, ccc2);
			assertEquals("Test that Category arraylist size is 2", 2, categoryList.size());
			
			//test if the expected output string same as the list of student retrieved from the SourceCentre	
			String categoryDetails= C206_CaseStudy.editCategoryDetails(categoryList, "Hi im lionel", ccc2.getId());
			String testoutput = "Successfully added";
		
			assertEquals("Test that viewAllParent", testoutput, categoryDetails);
			
		}
		
		@Test
		public void editCCADetailsTest() {
			// Test if parent list is not null but empty -boundary
			assertNotNull("Test if there is valid parent arraylist to retrieve students", ccaList);
			
			//Given an empty list, after adding 3 items, test if the size of the list is 3 - normal
			C206_CaseStudy.addCCA(ccaList, cc1);
			C206_CaseStudy.addCCA(ccaList, cc2);
			C206_CaseStudy.addCCA(ccaList, cc3);
			assertEquals("Test that CCA arraylist size is 3", 3, ccaList.size());
			
			//test if the expected output string same as the list of student retrieved from the SourceCentre	
			String ccaDetails= C206_CaseStudy.editCCADetails(ccaList, "Test 1" ,cc2.getCcaId());
			String output = "Test 1";
		
			assertEquals("Test that viewAllParent", output, ccaDetails);
			
		}
		
		//Forgot Registration ID
		@Test
		public void forgotRegID() {
			//Test that sms will only send when aswers are correct
			
			studentList.add(sl2);
			
			boolean result = false;
			
			String ans1 = "James";
			String ans2 = "August";
			
			int index = C206_CaseStudy.getindexviaID(2, studentList);
			if((ans1.equalsIgnoreCase(studentList.get(index).getQuestion1()[1]))&&(ans2.equalsIgnoreCase(studentList.get(index).getQuestion2()[1]))) {
				System.out.println("Registration ID has been sent to email of Student ID: " + 2);
				System.out.println("Password: " + studentList.get(index).getPassword());
				result=true;
			}else {
				System.out.println("Wrong answer");
				
			}
			
			assertTrue(result);
			
			//Test that the correct questions will show for the student ID
			
			
			assertEquals("Q1", studentList.get(index).getQuestion1()[0], "What is your father's name? ");
			assertEquals("Q2", studentList.get(index).getQuestion2()[0], "What is your birth month? ");
			
			//Test that the sms will sent the registration ID of the correct student ID
			
			assertEquals(studentList.get(index).getPassword(), "2");	
		}
		
		//View students registered for cca
		@Test
		public void viewStudentCCA() {
		studentList.add(sl2);
		ArrayList<Integer> templist = studentList.get(0).getRegisteredCCA();
		ccaList.add(cc1);
		C206_CaseStudy.addStudentCCA(templist, ccaList.get(0).getCcaId());
		//Test that only existing CCAs can be seen.	
		C206_CaseStudy.viewStudentCCA(templist ,ccaList);
		int tempid = templist.get(0);
		assertEquals(tempid, 1);
		//Test that view CCA will open the corresponding CCAÅfs list.
		int tempccaid = ccaList.get(0).getCcaId();
		assertEquals(tempid, tempccaid);
		}
		
	
	@After
	public void tearDown() throws Exception {
		cc1 = null;
		cc2 = null;
		sl1 = null;
		sl2 = null;
		ccaList = null;
		studentList = null;

	}
	

}
