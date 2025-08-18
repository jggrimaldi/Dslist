package com.grimaldi.dslist.services;

import com.grimaldi.dslist.dto.GameMinDto;
import com.grimaldi.dslist.entities.Game;
import com.grimaldi.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public List<GameMinDto> findAll(){
        List<Game> result = gameRepository.findAll();
        List<GameMinDto> dto = result.stream()
                .map(x -> new GameMinDto(x))
                .toList();
        return dto;
    }
}
