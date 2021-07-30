import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	private StudentList sl1;
	private StudentList sl2;
	private StudentList sl3;
	private CCA cc1;
	private CCA cc2;
	private CCA cc3;


	private ArrayList<StudentList> studentList;
	private ArrayList<CCA> ccaList;
	
	public C206_CaseStudyTest() {
		super();
	}

	@Before
	public void setUp() throws Exception {
		sl1 = new StudentList(1, "1", "Amy", "admin"); 
		sl2 = new StudentList(2, "2", "Tom", "member", 1, "James");
		sl3 = new StudentList(3, "3", "Sean", "member", 3, "Woman");
		
		cc1 = new CCA(1,"Sports", "Rock climbing,swimming etc", 10, "Monday", 3.00, 5.00,
				"Field", "Thomas");
		cc2 = new CCA(2,"Music", "Chance to use different instruments", 30, "Wednesday", 3.00, 6.00,
				"Music room", "Willy");
		cc3 = new CCA(3,"Photograph", "Experience to take photographs", 25, "Friday", 2.30, 5.00,
				"Photo room", "Annie");
		
		studentList= new ArrayList<StudentList>();
		ccaList= new ArrayList<CCA>();


	}

	// Add Student Test
	@Test
	public void addStudentTest() {
		// Student list is not null, so that can add a new item - boundary
		assertNotNull("Check if there is valid student arraylist to add to", studentList);
		//Given an empty list, after adding 1 student, the size of the list is 1 - normal
		//The item just added is as same as the first student of the list
		C206_CaseStudy.addStudent(studentList, sl1);
		assertEquals("Check that Student arraylist size is 1", 1, studentList.size());
		assertSame("Check that student is added", sl1, studentList.get(0));
		
		//Add another item. test The size of the list is 2? -normal
		//The item just added is as same as the second item of the list
		C206_CaseStudy.addStudent(studentList, sl2);
		assertEquals("Check that Student arraylist size is 2", 2, studentList.size());
		assertSame("Check that student is added", sl2, studentList.get(1));
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
		testOutput += String.format("%-10d %-10s %-35s %-10d %-10s %-10.2f %-10.2f %-15s %-10s\n", 2, "Music", "Chance to use different instruments", 30, "Wednesday",3.00, 6.00,
				"Music room", "Willy");
		
		assertEquals("Test that viewAllCCA", testOutput, allCCA);
		
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
