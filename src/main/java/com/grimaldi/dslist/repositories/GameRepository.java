package com.grimaldi.dslist.repositories;

import com.grimaldi.dslist.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}
