package com.example.alumnimanagement.repository;

import com.example.alumnimanagement.entity.Alumni;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumniRepository extends JpaRepository<Alumni, Long> {
    boolean existsByEmail(String email);
}
