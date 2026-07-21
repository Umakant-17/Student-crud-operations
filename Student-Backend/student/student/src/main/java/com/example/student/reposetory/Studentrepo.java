package com.example.student.reposetory;


import com.example.student.model.Student;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Studentrepo extends JpaRepository<Student,String> {
    Student findTopByOrderByStidDesc();

Optional<Student>findByEmail(String email);

}
