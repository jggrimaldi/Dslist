package com.grimaldi.dslist.services;

import com.grimaldi.dslist.dto.GameListDto;
import com.grimaldi.dslist.entities.GameList;
import com.grimaldi.dslist.repositories.GameListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Transactional(readOnly = true)
    public GameListDto findById(Long id) {
    //Buscar no banco de dados o GAME e converte para DTO
    GameList result = gameListRepository.findById(id).get();
    return new GameListDto(result);
    }

    @Transactional(readOnly = true)
    public List<GameListDto> findAll(){
        List<GameList> result = gameListRepository.findAll();
        return result.stream().map(GameListDto::new).toList();
    }
}
