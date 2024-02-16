package com.example.demo.controller;


import com.example.demo.entity.Games;
import com.example.demo.repository.IGamesRepository;
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

@Tag(name = "Games", description = "Listado de juegos")
@RestController
@RequestMapping("/api/v1")
public class GamesController {
    @Autowired
    private IGamesRepository iGamesRepository;

    @Operation(summary = "Obtiene el listado de todos los juegos")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Listado de juegos",
                    content = @Content(array = @ArraySchema(
                            schema = @Schema(implementation = Games.class)
                    ))
            )
    })

    @GetMapping("/games")
    public List<Games> getAllGames(){
        return iGamesRepository.findAll();
    }

    @Operation(summary = "Registra un nuevo juegos")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Se registra al juegos",
                    content = @Content(array = @ArraySchema(
                            schema = @Schema(implementation = Games.class)
                    ))
            )
    })
    @PostMapping("/games/new")
    public Games addGame(@RequestBody Games newGames){
        return iGamesRepository.save(newGames);
    }


    @Operation(summary = "Modifica a un juegos en el listado")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Se modifica al juegos",
                    content = @Content(array = @ArraySchema(
                    schema = @Schema(implementation = Games.class)
            ))
            )
    })
    @PatchMapping("/games/edit/{id}")
    public Games editGame(@PathVariable Integer id, @RequestBody Games games){
        Optional<Games> studentOptional = iGamesRepository.findById(id);
        if(studentOptional.isPresent()){
            Games currentGames = studentOptional.get();
            currentGames.setName(games.getName());
            currentGames.setDeveloper(games.getDeveloper());
            currentGames.setPublished(games.getIsPublished());
            currentGames.setIsretro(games.getIsretro());

            return iGamesRepository.save(currentGames);
        }
        return null;
    }

    @Operation(summary = "Obtiene un juego mediante su ID")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Existe el juego",
                    content = @Content(array = @ArraySchema(
                            schema = @Schema(implementation = Games.class)
                    ))
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "No existe el juego",
                    content = @Content(array = @ArraySchema(
                            schema = @Schema(implementation = ResponseEntity.class)
                    ))
            )
    })
    @GetMapping("/games/{id}")
    public Optional<Games> getGameById(@PathVariable Integer id){
        return iGamesRepository.findById(id);
    }

    @Operation(summary = "Elimina un juego")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "204",
                    description = "Se elimina al juego",
                    content = @Content(array = @ArraySchema(
                            schema = @Schema(implementation = ResponseEntity.class)
                    ))
            )
    })
    @DeleteMapping("/games/{id}")
    public void deleteGame(@PathVariable Integer id){
        iGamesRepository.deleteById(id);
    }

    @Operation(summary = "Elimina todos los juegos")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "204",
                    description = "Se elimino todos los juego",
                    content = @Content(array = @ArraySchema(
                            schema = @Schema(implementation = ResponseEntity.class)
                    ))
            )
    })
    @DeleteMapping("/games/delete")
    public void deleteAllGames(){
        iGamesRepository.deleteAll();
    }

}
