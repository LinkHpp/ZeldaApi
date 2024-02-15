package com.example.demo.controller;


import com.example.demo.entity.Student;
import com.example.demo.repository.IStudentRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

import java.util.List;

@Tag(name = "Students", description = "Listado de Estudiantes")
@RestController
@RequestMapping("/api/v1")
public class StudentController {
    @Autowired
    private IStudentRepository iStudentRepository;

    @Operation(summary = "Obtiene el listado de todos los estudiantes")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Listado de estudiantes",
                    content = @Content(array = @ArraySchema(
                            schema = @Schema(implementation = Student.class)
                    ))
            )
    })

    @GetMapping("/students")
    public List<Student> getAllStudents(){
        return iStudentRepository.findAll();
    }

    @Operation(summary = "Registra un nuevo Producto")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Se registra al estudiante",
                    content = @Content(array = @ArraySchema(
                            schema = @Schema(implementation = Student.class)
                    ))
            )
    })
    @PostMapping("/students/new")
    public Student addStudent(@RequestBody Student newStudent){
        return iStudentRepository.save(newStudent);
    }


    @Operation(summary = "Modifica a un estudiante en el listado")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Se modifica al estudiante",
                    content = @Content(array = @ArraySchema(
                    schema = @Schema(implementation = Student.class)
            ))
            )
    })
    @PatchMapping("/students/edit/{id}")
    public Student editStudent(@PathVariable Integer id, @RequestBody Student student){
        Optional<Student> studentOptional = iStudentRepository.findById(id);
        if(studentOptional.isPresent()){
            Student currentStudent = studentOptional.get();
            currentStudent.setName(student.getName());
            currentStudent.setLastname(student.getLastname());
            currentStudent.setEmail(student.getEmail());

            return iStudentRepository.save(currentStudent);
        }
        return null;
    }

    @Operation(summary = "Obtiene un estudiante mediante su ID")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Existe el estudiante",
                    content = @Content(array = @ArraySchema(
                            schema = @Schema(implementation = Student.class)
                    ))
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "No existe el estudiante",
                    content = @Content(array = @ArraySchema(
                            schema = @Schema(implementation = ResponseEntity.class)
                    ))
            )
    })
    @GetMapping("/students/{id}")
    public Optional<Student> getStudentById(@PathVariable Integer id){
        return iStudentRepository.findById(id);
    }

    @Operation(summary = "Elimina un estudiante")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "204",
                    description = "Se elimina al estudiante",
                    content = @Content(array = @ArraySchema(
                            schema = @Schema(implementation = ResponseEntity.class)
                    ))
            )
    })
    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable Integer id){
        iStudentRepository.deleteById(id);
    }

}
