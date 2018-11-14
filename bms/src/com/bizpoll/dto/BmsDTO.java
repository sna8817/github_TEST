package com.bizpoll.dto;

public class BmsDTO {
	private int id;
	private String name;
	private int age;
	private String major;
	private int phone;
	
	public BmsDTO() {
		
	}

	public BmsDTO(int id, String name, int age, String major, int phone) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.major = major;
		this.phone = phone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "BmsDTO [id=" + id + ", name=" + name + ", age=" + age + ", major=" + major + ", phone=" + phone + "]";
	}
	
	
	
}
