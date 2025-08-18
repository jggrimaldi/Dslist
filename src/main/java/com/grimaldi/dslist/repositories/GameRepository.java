package com.grimaldi.dslist.repositories;

import com.grimaldi.dslist.entities.Game;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Id> {
}
