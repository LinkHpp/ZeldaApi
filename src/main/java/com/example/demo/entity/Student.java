package com.example.demo.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "students_db")
public class Student {

    @Schema(description = "Identificador del estudiante", example = "1")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_Courses")
    private Integer id;

    @Schema(description = "Nombre del estudiante", example = "Hermes")
    @Size(max = 255, message = "Maximo 255 caracteres")
    @Column(nullable = true, name="name")
    private String name;

    @Schema(description = "Apellidos del estudiante", example = "Pérez Parrondo")
    @Size(max = 255, message = "Maximo 255 caracteres")
    @Column(nullable = true,name= "lastname")
    private String lastname;

    @Schema(description = "Email del estudiante", example = "herperpar@alu.edu.gva.es")
    @Size(max = 255, message = "Maximo 255 caracteres")
    @Column(nullable = true,name= "email")
    private String email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
