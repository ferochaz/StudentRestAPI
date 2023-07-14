package br.com.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.student.model.Student;
import br.com.student.repositories.StudentRepository;

@Service
public class StudentService {

	@Autowired
	StudentRepository stRepository;
	
	public List<Student>findAllStudents()throws Exception{
		
		return stRepository.findAll();
	}
	
	public Student findById(Long id) throws Exception{
		
		return stRepository.findById(id).orElseThrow(()-> new RuntimeException("Could not find by Id"));
	}
	
	public Student createStudent(Student student)throws Exception {
		
		return stRepository.save(student);
	}
	
	public Student readStudent(Student student)throws Exception {
		
		return student;
	}
	
	public Student updateStudent(Student student) throws Exception {
		
		var updatedStudent = stRepository.findById(student.getId()).orElseThrow(()-> new RuntimeException("Could not update student"));
		
		updatedStudent.setFirstName(student.getFirstName());
		updatedStudent.setLastName(student.getLastName());
		updatedStudent.setFirstGrade(student.getFirstGrade());
		updatedStudent.setSecondGrade(student.getSecondGrade());
		updatedStudent.setThirdGrade(student.getThirdGrade());
		
		return stRepository.save(student);
	}
	
	public void deleteStudent(Long id) {
		
		 var deletedStudent = stRepository.findById(id).orElseThrow(()-> new RuntimeException("could not delete the student"));
		 
		 stRepository.delete(deletedStudent);
	}
}
