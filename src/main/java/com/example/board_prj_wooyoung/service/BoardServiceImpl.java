package com.example.board_prj_wooyoung.service;

import com.example.board_prj_wooyoung.dto.BoardDTO;
import com.example.board_prj_wooyoung.dto.PageRequestDTO;
import com.example.board_prj_wooyoung.dto.PageResultDTO;
import com.example.board_prj_wooyoung.entity.Board;
import com.example.board_prj_wooyoung.entity.Member;
import com.example.board_prj_wooyoung.repository.BoardRepository;
import com.example.board_prj_wooyoung.repository.ReplyRepository;
import java.util.function.Function;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;

    private final ReplyRepository replyRepository;

    @Override
    public Long register(BoardDTO dto) {

        log.info(dto);

        Board board = dtoToEntity(dto);

        boardRepository.save(board);

        return board.getBno();
    }

    @Override
    public PageResultDTO<BoardDTO, Object[]> getList(PageRequestDTO pageRequestDTO) {
        log.info(pageRequestDTO);

        Function<Object[], BoardDTO> fn = en -> entityToDTO((Board) en[0], (Member) en[1],
            (Long) en[2]);

        Page<Object[]> result = boardRepository.getBoardWithReplyCount(
            pageRequestDTO.getPageable(Sort.by("bno").descending())
        );
        return new PageResultDTO<>(result, fn);
    }

    @Override
    public BoardDTO get(Long bno) {

        Object result = boardRepository.getBoardByBno(bno);

        Object[] arr = (Object[]) result;

        return entityToDTO((Board) arr[0], (Member) arr[1], (Long) arr[2]);
    }

    @Transactional
    @Override
    public void removeWithReplies(Long bno) {

        replyRepository.deleteByBno(bno);

        boardRepository.deleteById(bno);

    }
}
