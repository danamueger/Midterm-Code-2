package com.cisc181.core;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cisc181.eNums.eTitle;

public class Staff_Test {

	@BeforeClass
	public static void setup() {
	}
	
	@Test
	public void testStaffAvgSal() throws PersonException {
		ArrayList<Staff> TestStaff = new ArrayList<Staff>();
		
		Staff One = new Staff("Madeline", "Rose", "Merritts", new Date(), "171 South Chapel Street, Newark, DE", "(201)-893-3007", "mmerritts@udel.edu", "None", 1, 6000.00, new Date(), eTitle.MS);
		TestStaff.add(One);
		
		Staff Two = new Staff("Aly", "Lorraine", "McGrath", new Date(), "171 South Chapel Street, Newark, DE", "(908)-821-5030", "amcgrath@udel.edu", "None", 2, 7000.00, new Date(), eTitle.MRS);
		TestStaff.add(Two);
		
		Staff Three = new Staff("William", "Thomas", "Johansen", new Date(), "1007 Woolen Way, Newark, DE", "(302)-757-2175", "willjohan@gmail.com", "None", 3, 8000.00, new Date(), eTitle.MR);
		TestStaff.add(Three);
		
		Staff Four = new Staff("Audrey", "Eileen", "Morris", new Date(), "45 Peachtree Drive, East Norwich, NY", "(516)-353-9816", "amorris@bc.edu", "None", 4, 3000.00, new Date(), eTitle.MS);
		TestStaff.add(Four);
		
		Staff Five = new Staff("Jack", "Micheal", "Mueger", new Date(), "7 Oberlon Drive, Greenlawn, NY", "(631)-827-6978", "jmm@gmail.com", "None", 5, 9000.00, new Date(), eTitle.MR);
		TestStaff.add(Five);
		
		double AvgSalary = 0;
		for(Staff s : TestStaff) {
			AvgSalary += s.getSalary();
		}
		AvgSalary /= 5;
		
		int f = (int) AvgSalary;
		
		assertEquals(f, 6600);
		
	}	
	
	@Test(expected = PersonException.class)
	public void testPhoneNumberException() throws PersonException {
		Staff Six = new Staff("Tom", "C", "Mueger", new Date(2500, 12, 14), "7 Oberlon Drive, Greenlawn, NY", "", "tom@udel.edu", "None", 1, 4000, new Date(2014, 5, 24), eTitle.MR);	
	}

	@Test
	public void testAgeException() throws PersonException {
		Staff Seven = new Staff("Meghan", "Patrice", "Hardiman", new Date(1699, 3, 29), "23 Cherry Lane, Huntington, NY", "(586)-938-9846", "mhardiman@ucla.edu", "None", 6, 15000.00, new Date(), eTitle.MS);
	}

}







