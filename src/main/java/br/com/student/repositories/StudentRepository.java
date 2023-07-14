package br.com.student.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.student.model.Student;

public interface StudentRepository extends JpaRepository<Student,Long> {

}
