package com.careerpath.placement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.careerpath.placement.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {}
