package com.example.board_prj_wooyoung.repository;

import static org.junit.jupiter.api.Assertions.*;

import com.example.board_prj_wooyoung.entity.Board;
import com.example.board_prj_wooyoung.entity.Member;
import java.util.Optional;
import java.util.stream.IntStream;
import javax.transaction.Transactional;
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

    @Transactional /* 지연 로딩으로 설정했는데, writer를 불러오려 하니 세션이 끊어지는 error 발생. so, transactional 지정*/
    @Test
    public void testRead1() {

        Optional<Board> result = boardRepository.findById(100L);

        Board board = result.get();

        System.out.println(board);
        System.out.println(board.getWriter());

    }
}