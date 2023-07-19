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
import br.com.student.service.StudentService;
import br.com.student.vo.StudentVO;

@RestController
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
	private StudentService stService;
	
	@GetMapping(produces= MediaType.APPLICATION_JSON_VALUE)
	public List<StudentVO>findAllStudents()throws Exception{
		
		return stService.findAllStudents();
	} 
	
	
	@GetMapping(value="/findStudentById/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public StudentVO findById(@PathVariable (value="id")Long id)throws Exception{
		
		return stService.findById(id);
	}
	
	
	
	@PostMapping(value = "/newStudent",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public StudentVO createStudent(@RequestBody StudentVO student) throws Exception {
		
		return stService.createStudent(student);
	}
	
	@PutMapping(value ="/updateStudent",consumes = MediaType.APPLICATION_JSON_VALUE)
	public StudentVO updateStudent(@RequestBody StudentVO student) throws Exception{
		
		return stService.updateStudent(student);
	}
	
	@DeleteMapping(value = "deleteStudent/{id}")
	public ResponseEntity<?> deleteStudent(@PathVariable(value="id")Long id)throws Exception{
		
		stService.deleteStudent(id);
		return ResponseEntity.noContent().build();
	}


}
