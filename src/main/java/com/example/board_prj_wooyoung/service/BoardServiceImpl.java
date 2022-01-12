package com.example.board_prj_wooyoung.service;

import com.example.board_prj_wooyoung.dto.BoardDTO;
import com.example.board_prj_wooyoung.entity.Board;
import com.example.board_prj_wooyoung.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;

    @Override
    public Long register(BoardDTO dto) {

        log.info(dto);

        Board board = dtoToEntity(dto);

        boardRepository.save(board);

        return board.getBno();
    }
}
