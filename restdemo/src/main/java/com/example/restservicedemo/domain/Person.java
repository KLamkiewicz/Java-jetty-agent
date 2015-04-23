package com.example.restservicedemo.domain;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Person {
	
	private String firstName;
	private int yob;
	
	public Person() {
	}

	public Person(String firstName, int yob) {
		this.firstName = firstName;
		this.yob = yob;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public int getYob() {
		return yob;
	}
	public void setYob(int yob) {
		this.yob = yob;
	}
	
	public void doSomething(){
		System.out.println("done nothing");
	}
}
