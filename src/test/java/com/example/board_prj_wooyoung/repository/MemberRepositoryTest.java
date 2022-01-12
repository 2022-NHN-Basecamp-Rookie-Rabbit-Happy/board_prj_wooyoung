package com.example.board_prj_wooyoung.repository;

import static org.junit.jupiter.api.Assertions.*;

import com.example.board_prj_wooyoung.entity.Member;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void insertMembers() {
        IntStream.rangeClosed(1, 100).forEach(i -> {

            Member member = Member.builder()
                .email("user" + i + "@aaa.com")
                .password("1111")
                .name("USER" + i)
                .build();

            memberRepository.save(member);
        });
    }
}