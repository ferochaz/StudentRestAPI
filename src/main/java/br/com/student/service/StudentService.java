package br.com.student.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.student.model.Student;
import br.com.student.repositories.StudentRepository;
import br.com.student.vo.StudentVO;
import br.com.students.dozer.mapper.StudentDozerMapper;

@Service
public class StudentService {

	@Autowired
	StudentRepository stRepository;
	
	public List<StudentVO>findAllStudents()throws Exception{
		
		return StudentDozerMapper.convertListOfStudents(stRepository.findAll(),StudentVO.class);
	}
	
	public StudentVO findById(Long id) throws Exception{
		
		var entity= stRepository.findById(id).orElseThrow(()-> new RuntimeException("Could not find by Id"));
		
		return StudentDozerMapper.convertOneStudent(entity,StudentVO.class);
	}
	
	public StudentVO createStudent(StudentVO studentVO)throws Exception {
		
		var entity = StudentDozerMapper.convertOneStudent(studentVO,Student.class);
		
		var vo = StudentDozerMapper.convertOneStudent(stRepository.save(entity),StudentVO.class);
		
		return vo;
	}
	
	public StudentVO readStudent(StudentVO StudentVO)throws Exception {
		
		return StudentVO;
	}
	
	public StudentVO updateStudent(StudentVO StudentVO) throws Exception {
		
		var updatedStudent = stRepository.findById(StudentVO.getId()).orElseThrow(()-> new RuntimeException("Could not update StudentVO"));
		
		updatedStudent.setFirstName(StudentVO.getFirstName());
		updatedStudent.setLastName(StudentVO.getLastName());
		updatedStudent.setFirstGrade(StudentVO.getFirstGrade());
		updatedStudent.setSecondGrade(StudentVO.getSecondGrade());
		updatedStudent.setThirdGrade(StudentVO.getThirdGrade());
		
		var vo = StudentDozerMapper.convertOneStudent(stRepository.save(updatedStudent),StudentVO.class);
		
		return vo;
	}
	
	public void deleteStudent(Long id) {
		
		 var deletedStudent = stRepository.findById(id).orElseThrow(()-> new RuntimeException("could not delete the StudentVO"));
		 
		 stRepository.delete(deletedStudent);
	}
}
