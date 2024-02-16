package com.example.demo.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "games_db")
public class Games {

    @Schema(description = "Identificador del estudiante", example = "1")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_Courses")
    private Integer id;

    @Schema(description = "Nombre del estudiante", example = "The Legend of Zelda: Ocarina of Time")
    @Size(max = 255, message = "Maximo 255 caracteres")
    @Column(nullable = true, name="name")
    private String name;

    @Schema(description = "Desarrollador del Juego", example = "Nintendo")
    @Size(max = 255, message = "Maximo 255 caracteres")
    @Column(nullable = true,name= "developer")
    private String developer;

    @Schema(description = "Esta publicado el juego", example = "true")
    @Column(nullable = false,name= "isPublished")
    @NotNull
    private boolean isPublished;


    @Schema(description = "Indica si es retro el juego o no", example = "RETRO")
    @NotNull
    @Enumerated(EnumType.STRING)
    private Enums.isRetro isretro;

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

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public boolean getIsPublished() {
        return isPublished;
    }

    public void setPublished(boolean published) {
        isPublished = published;
    }

    public Enums.isRetro getIsretro() {
        return isretro;
    }

    public void setIsretro(Enums.isRetro isretro) {
        this.isretro = isretro;
    }
}
