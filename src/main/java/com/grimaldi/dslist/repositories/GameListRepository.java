package com.grimaldi.dslist.repositories;

import com.grimaldi.dslist.entities.GameList;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

//Interface para a comunicação com o banco de dados
public interface GameListRepository extends JpaRepository<GameList, Long> {

    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "UPDATE tb_belonging " +
            "SET position = :newPosition " +
            "WHERE list_id = :listId " +
            "AND game_id = :gameId")
    void updateBelongingPosition(Long listId, Long gameId, Integer newPosition);

}
