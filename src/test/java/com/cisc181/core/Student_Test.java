package com.cisc181.core;

import static org.junit.Assert.*;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cisc181.eNums.eMajor;

public class Student_Test{

	static ArrayList<Enrollment> EnrollmentList = new ArrayList<Enrollment>();
		
	@BeforeClass
	public static void setup() throws PersonException{
		Course C1 = new Course(UUID.randomUUID(), "Discrete Mathematics", 3);
		Course C2 = new Course(UUID.randomUUID(), "Computer Science", 4);
		Course C3 = new Course(UUID.randomUUID(), "Linear Algebra", 3);
		ArrayList<Course> CourseList = new ArrayList<Course>(3);
			
		CourseList.add(C1);
		CourseList.add(C2);
		CourseList.add(C3);
			
		Date FallStart = new Date(2017, 8, 30);
		Date FallEnd = new Date(2017, 12, 6);
		Semester Fall = new Semester(UUID.randomUUID(), FallStart, FallEnd);
		Date SpringStart = new Date();
		Date SpringEnd = new Date();
		Semester Spring = new Semester(UUID.randomUUID(), SpringStart, SpringEnd);
		ArrayList<Semester> SemesterList = new ArrayList<Semester>(2);
		SemesterList.add(Fall);
		SemesterList.add(Spring);
				
		Section DiscreteMath1 = new Section(C1.getCourseID(), Fall.getSemesterID(), UUID.randomUUID(), 210);
		Section DiscreteMath2 = new Section(C1.getCourseID(), Spring.getSemesterID(), UUID.randomUUID(), 210);
		Section CompSci1 = new Section(C2.getCourseID(), Fall.getSemesterID(), UUID.randomUUID(), 106);
		Section CompSci2 = new Section(C2.getCourseID(), Spring.getSemesterID(), UUID.randomUUID(), 106);
		Section LinAlg1 = new Section(C3.getCourseID(), Fall.getSemesterID(), UUID.randomUUID(), 349);
		Section LinAlg2 = new Section(C3.getCourseID(), Spring.getSemesterID(), UUID.randomUUID(), 349);
		ArrayList<Section> SectionList = new ArrayList<Section>(6);
			
		SectionList.add(DiscreteMath1);
		SectionList.add(DiscreteMath2);
		SectionList.add(CompSci1);
		SectionList.add(CompSci2);
		SectionList.add(LinAlg1);
		SectionList.add(LinAlg2);
			
		Student S1 = new Student("Mike", "A", "Holmes", new Date(), eMajor.CHEM, "427 Newark Ave", "123467890", "mholmes@udel.edu", 3.0);
		Student S2 = new Student("Sam", "B", "Zakrzewski", new Date(), eMajor.BUSINESS, "117 East Cleavland Ave", "9735706146", "szak@udel.edu", 3.1);
		Student S3 = new Student("Megan", "C", "Kelly", new Date(), eMajor.NURSING, "207 South Chapel St", "9739063880", "mekelly@udel.edu", 3.2);
		Student S4 = new Student("Michela", "D", "Licata", new Date(), eMajor.PHYSICS, "209 South Chapel St", "9708907513", "mlicata@udel.edu", 3.3);
		Student S5 = new Student("Caroline", "E", "Grossman", new Date(), eMajor.COMPSI, "50 Cleveland St", "3098278451", "cgrossman@udel.edu", 3.4);
		Student S6 = new Student("Andy", "F", "Margulis", new Date(), eMajor.PHYSICS, "17 Annabelle St", "9735170988", "amarg@udel.edu", 3.5);
		Student S7 = new Student("Tim", "G", "Horne", new Date(), eMajor.BUSINESS, "38 Continental Rd", "9734578133", "thorne@udel.edu", 3.6);
		Student S8 = new Student("Allyssa", "H", "Myers", new Date(), eMajor.CHEM, "13 Center St", "9806142377", "amyers@udel.edu", 3.7);
		Student S9 = new Student("Brooke", "I", "Kraska", new Date(), eMajor.NURSING, "25 New London St", "3085732544", "bkraska@udel.edu", 3.8);
		Student S10 = new Student("Thomas", "J", "Ruggiero", new Date(), eMajor.COMPSI, "119 East Cleveland Ave", "9075623400", "truggs@udel.edu", 3.9); 
		ArrayList<Student> StudentList = new ArrayList<Student>(10);
			
		StudentList.add(S1);
		StudentList.add(S2);
		StudentList.add(S3);
		StudentList.add(S4);
		StudentList.add(S5);
		StudentList.add(S6);
		StudentList.add(S7);
		StudentList.add(S8);
		StudentList.add(S9);
		StudentList.add(S10);
			
		for (Section section : SectionList) {
			for (Student student : StudentList) {
				EnrollmentList.add(new Enrollment(student.getStudentID(), section.getSectionID()));
			}
		}
	}
	

	@Test
	public void testGPA() throws PersonException {
		ArrayList<Student> StudentList = new ArrayList<Student>(10);
		double AvgGPA = 0;
		for(Student student : StudentList) {
			AvgGPA += student.getGPA();
		}
		AvgGPA /= 10;
		
		int f = (int) AvgGPA;
		
		assertEquals(f, 3.45);
		
	}
}