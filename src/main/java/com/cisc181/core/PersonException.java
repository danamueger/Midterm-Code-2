package com.cisc181.core;

public class PersonException extends Exception {
	private Person person;
	
	public PersonException(Person p) {
		this.setPerson(p);	
	}
	
	public Person getPerson() {
		return person;
	}
	
	public void setPerson(Person person) {
		this.person = person;
	}


}
