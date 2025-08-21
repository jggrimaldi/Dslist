package com.grimaldi.dslist.controllers;

import com.grimaldi.dslist.dto.GameListDto;
import com.grimaldi.dslist.dto.GameMinDto;
import com.grimaldi.dslist.dto.ReplacementDto;
import com.grimaldi.dslist.services.GameListService;
import com.grimaldi.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;

    @Autowired
    private GameService gameService;

    @GetMapping(value = "/{id}")
    public GameListDto findById(@PathVariable Long id) {
        GameListDto result = gameListService.findById(id);
        return result;
    }

    @GetMapping
    public List<GameListDto> findAll(){
        List<GameListDto>  result = gameListService.findAll();
        return result;
    }

    @GetMapping(value = "/{listId}/games")
    public List<GameMinDto> findByList(@PathVariable Long listId){
        List<GameMinDto>  result = gameService.findByList(listId);
        return result;

    }

    @PostMapping(value = "/{listId}/replacement")
    //@Requestbody faz com a API retorne um corpo JSON que vai ser o ReplacementDTO
    public void move(@PathVariable Long listId, @RequestBody ReplacementDto body){
        gameListService.move(listId, body.getSourceIndex(), body.getDestinationIndex());
    }


}
