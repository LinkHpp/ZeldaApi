package com.example.demo.controller;


import com.example.demo.entity.Course;
import com.example.demo.repository.ICourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class StudentController {
    @Autowired
    private ICourseRepository ICourseRepository;

    @GetMapping("/courses")
    public List<Course> getAllCourses(){
        return ICourseRepository.findAll();
    }
    @PostMapping("/courses/new")
    public Course addCourse(@RequestBody Course newCourse){
        return ICourseRepository.save(newCourse);
    }
    @PostMapping("/courses/edit/{id}")
    public Course editCourse(@PathVariable Integer id, @RequestBody Course course){
        Optional<Course> courseOptional = ICourseRepository.findById(id);
        if(courseOptional.isPresent()){
            Course currentCourse = courseOptional.get();
            currentCourse.setTitle(course.getTitle());
            currentCourse.setPrice(course.getPrice());
            return ICourseRepository.save(currentCourse);
        }
        return null;
    }
    @GetMapping("/courses/{id}")
    public Optional<Course> getCourseById(@PathVariable Integer id){
        return ICourseRepository.findById(id);
    }
    @DeleteMapping("/courses/{id}")
    public void deleteCourse(@PathVariable Integer id){
        ICourseRepository.deleteById(id);
    }

}
