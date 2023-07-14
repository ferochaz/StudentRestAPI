package br.com.student.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="Students")
public class Student implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="FIRST_NAME",nullable=false,length=80)
	private String firstName;
	@Column(name="LAST_NAME",nullable=false,length=80)
	private String lastName;
	@Column(name="AGE",nullable=false)
	private int age;
	@Column(name="FIRST_GRADE",nullable=false)
	private double firstGrade;
	@Column(name="SECOND_GRADE",nullable=false)
	private double secondGrade;
	@Column(name="THIRD_GRADE",nullable=false)
	private double thirdGrade;
	
	
	public Student() {
	}
	
	public Student(Long id, String firstName, String lastName, int age, double firstGrade, double secondGrade,
			double thirdGrade) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.firstGrade = firstGrade;
		this.secondGrade = secondGrade;
		this.thirdGrade = thirdGrade;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public double getFirstGrade() {
		return firstGrade;
	}


	public void setFirstGrade(double firstGrade) {
		this.firstGrade = firstGrade;
	}


	public double getSecondGrade() {
		return secondGrade;
	}


	public void setSecondGrade(double secondGrade) {
		this.secondGrade = secondGrade;
	}


	public double getThirdGrade() {
		return thirdGrade;
	}


	public void setThirdGrade(double thirdGrade) {
		this.thirdGrade = thirdGrade;
	}
	
	
	
	
	
	

}
