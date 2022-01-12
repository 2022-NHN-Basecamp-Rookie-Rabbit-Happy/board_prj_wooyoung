package com.example.board_prj_wooyoung.repository;

import static org.junit.jupiter.api.Assertions.*;

import com.example.board_prj_wooyoung.entity.Board;
import com.example.board_prj_wooyoung.entity.Member;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BoardRepositoryTest {

    @Autowired
    private BoardRepository boardRepository;

    @Test
    public void insertBoard() {

        IntStream.rangeClosed(1, 100).forEach(i -> {

            Member member = Member.builder()
                .email("user" + i + "@aaa.com")
                .build();

            Board board = Board.builder()
                .title("Title..." + i)
                .content("Content..." + i)
                .writer(member)
                .build();

            boardRepository.save(board);

        });
    }
}