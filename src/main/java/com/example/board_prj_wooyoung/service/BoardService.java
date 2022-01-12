package com.example.board_prj_wooyoung.service;


import com.example.board_prj_wooyoung.dto.BoardDTO;
import com.example.board_prj_wooyoung.entity.Board;
import com.example.board_prj_wooyoung.entity.Member;

public interface BoardService {

    Long register(BoardDTO dto);

    default Board dtoToEntity(BoardDTO dto) {

        Member member = Member.builder()
            .email(dto.getWriterEmail())
            .build();

        Board board = Board.builder()
            .bno(dto.getBno())
            .title(dto.getTitle())
            .content(dto.getContent())
            .writer(member)
            .build();

        return board;
    }
}
