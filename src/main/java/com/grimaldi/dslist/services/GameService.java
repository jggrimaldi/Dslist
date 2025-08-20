package com.grimaldi.dslist.services;

import com.grimaldi.dslist.dto.GameDto;
import com.grimaldi.dslist.dto.GameMinDto;
import com.grimaldi.dslist.entities.Game;
import com.grimaldi.dslist.projections.GameMinProjection;
import com.grimaldi.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//Logica de negócios da aplicação
@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    //gerenciar transações no banco de dados.
    @Transactional(readOnly = true)
    public GameDto findById(Long id) {
        //Buscar no banco de dados o GAME e converte para DTO
        Game result = gameRepository.findById(id).get();
        return new GameDto(result);
    }

    @Transactional(readOnly = true)
    public List<GameMinDto> findAll(){
        List<Game> result = gameRepository.findAll();
        return result.stream()
                .map(GameMinDto::new)
                .toList();
    }

    public List<GameMinDto> findByList(Long ListId){
        List<GameMinProjection> result = gameRepository.searchByList(ListId);
        return result.stream().map(GameMinDto::new).toList();
    }
}
