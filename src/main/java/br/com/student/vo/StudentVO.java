package br.com.student.vo;

import java.io.Serializable;
import java.util.Objects;


public class StudentVO implements Serializable{
	
	@Override
	public int hashCode() {
		return Objects.hash(age, firstGrade, firstName, id, lastName, secondGrade, thirdGrade);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentVO other = (StudentVO) obj;
		return age == other.age && Double.doubleToLongBits(firstGrade) == Double.doubleToLongBits(other.firstGrade)
				&& Objects.equals(firstName, other.firstName) && Objects.equals(id, other.id)
				&& Objects.equals(lastName, other.lastName)
				&& Double.doubleToLongBits(secondGrade) == Double.doubleToLongBits(other.secondGrade)
				&& Double.doubleToLongBits(thirdGrade) == Double.doubleToLongBits(other.thirdGrade);
	}


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	private Long id;
	
	private String firstName;

	private String lastName;

	private int age;

	private double firstGrade;

	private double secondGrade;

	private double thirdGrade;
	
	
	public StudentVO() {
	}
	
	public StudentVO(Long id, String firstName, String lastName, int age, double firstGrade, double secondGrade,
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
