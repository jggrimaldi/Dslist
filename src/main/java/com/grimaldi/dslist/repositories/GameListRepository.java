package com.grimaldi.dslist.repositories;

import com.grimaldi.dslist.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

//Interface para a comunicação com o banco de dados
public interface GameListRepository extends JpaRepository<GameList, Long> {
}
