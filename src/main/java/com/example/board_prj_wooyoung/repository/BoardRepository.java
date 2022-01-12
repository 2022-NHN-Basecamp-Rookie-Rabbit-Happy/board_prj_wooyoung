package com.example.board_prj_wooyoung.repository;

import com.example.board_prj_wooyoung.entity.Board;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BoardRepository extends JpaRepository<Board, Long> {

    @Query("SELECT b, w from Board b LEFT JOIN b.writer w WHERE b.bno = :bno")
    Object getBoardWithWriter(@Param("bno") Long bno);

    @Query("SELECT b, r from Board b LEFT JOIN Reply r ON r.board = b WHERE b.bno = :bno")
    List<Object[]> getBoardWithReply(@Param("bno") Long bno);
}
