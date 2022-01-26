package com.springboot.rest_api01;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

//@Component//By using that annotation, you are telling spring boot 
//to create an object from StudentBean01 and put it into IOC Container

@RestController
public class StudentBean01 implements StudentInterface{ //The object in IOC Container is called Bean
	private String id;
	private String name;
	private int age;
	public StudentBean01() {
		System.out.println("Constractor without parameter 01");
	}
	public StudentBean01(String id, String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
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
	@Override
	public String toString() {
		return "StudentBean01 [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
	
	@Override
	public String study() {
		return "Students must study 01";
	}
}
