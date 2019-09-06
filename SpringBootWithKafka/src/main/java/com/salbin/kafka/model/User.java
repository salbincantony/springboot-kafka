package com.salbin.kafka.model;

public class User {
	private String dept;
	private String name;
	private long salary;

	public User(String dept, String name, long salary) {
		super();
		this.dept = dept;
		this.name = name;
		this.salary = salary;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

}
