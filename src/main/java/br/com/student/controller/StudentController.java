package br.com.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.student.model.Student;
import br.com.student.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
	private StudentService stService;
	
	@GetMapping(produces= MediaType.APPLICATION_JSON_VALUE)
	public List<Student>findAllStudents()throws Exception{
		
		return stService.findAllStudents();
	} 
	
	
	@GetMapping(value="{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Student findById(@PathVariable (value="id")Long id)throws Exception{
		
		return stService.findById(id);
	}
	
	
	
	@PostMapping(value = "/{id}",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public Student createStudent(@RequestBody Student student) throws Exception {
		
		return stService.createStudent(student);
	}
	
	@PutMapping(value ="/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
	public Student updateStudent(@RequestBody Student student) throws Exception{
		
		return stService.updateStudent(student);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteStudent(@PathVariable(value="id")Long id)throws Exception{
		
		stService.deleteStudent(id);
		return ResponseEntity.noContent().build();
	}


}
