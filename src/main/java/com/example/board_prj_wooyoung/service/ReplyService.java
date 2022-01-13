package com.example.board_prj_wooyoung.service;

import com.example.board_prj_wooyoung.dto.ReplyDTO;
import com.example.board_prj_wooyoung.entity.Board;
import com.example.board_prj_wooyoung.entity.Reply;
import java.util.List;

public interface ReplyService {

    Long register(ReplyDTO replyDTO);

    List<ReplyDTO> getList(Long bno);

    void modify(ReplyDTO replyDTO);

    void remove(Long rno);

    default Reply dtoToEntity(ReplyDTO replyDTO) {

        Board board = Board.builder().bno(replyDTO.getBno()).build();

        Reply reply = Reply.builder()
            .rno(replyDTO.getRno())
            .text(replyDTO.getText())
            .replyer(replyDTO.getReplyer())
            .board(board)
            .build();

        return reply;
    }

    default ReplyDTO entityToDTO(Reply reply) {
        ReplyDTO replyDTO = ReplyDTO.builder()
            .rno(reply.getRno())
            .text(reply.getText())
            .replyer(reply.getReplyer())
            .regDate(reply.getRegDate())
            .modDate(reply.getModDate())
            .build();

        return replyDTO;
    }
}
