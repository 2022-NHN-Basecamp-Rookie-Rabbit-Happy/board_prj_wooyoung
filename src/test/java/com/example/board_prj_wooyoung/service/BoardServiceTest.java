package com.example.board_prj_wooyoung.service;

import static org.junit.jupiter.api.Assertions.*;

import com.example.board_prj_wooyoung.dto.BoardDTO;
import com.example.board_prj_wooyoung.dto.PageRequestDTO;
import com.example.board_prj_wooyoung.dto.PageResultDTO;
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

    @Test
    public void testList() {

        PageRequestDTO pageRequestDTO = new PageRequestDTO();

        PageResultDTO<BoardDTO, Object[]> result = boardService.getList(pageRequestDTO);

        for (BoardDTO boardDTO : result.getDtoList()) {
            System.out.println(boardDTO);
        }

    }

    @Test
    public void testGet() {

        Long bno = 100L;

        BoardDTO boardDTO = boardService.get(bno);

        System.out.println(boardDTO);

    }
}