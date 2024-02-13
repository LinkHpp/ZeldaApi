package com.example.demo.repository;

import com.example.demo.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "courses", collectionResourceRel = "courses")
public interface ICourseRepository extends JpaRepository<Course, Integer> {
}
