package com.example.board_prj_wooyoung.service;

import static org.junit.jupiter.api.Assertions.*;

import com.example.board_prj_wooyoung.dto.BoardDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BoardServiceTest {

    @Autowired
    private BoardService boardService;

    @Test
    public void testRegister() {

        BoardDTO dto = BoardDTO.builder()
            .title("Test.")
            .content("Test...")
            .writerEmail("user55@aaa.com")
            .build();

        Long bno = boardService.register(dto);
    }
}