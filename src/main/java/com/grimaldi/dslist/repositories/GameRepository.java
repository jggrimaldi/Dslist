package com.grimaldi.dslist.repositories;

import com.grimaldi.dslist.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

//Interface para a comunicação com o banco de dados
public interface GameRepository extends JpaRepository<Game, Long> {
}
