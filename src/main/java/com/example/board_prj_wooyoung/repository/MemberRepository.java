package com.example.board_prj_wooyoung.repository;

import com.example.board_prj_wooyoung.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, String> {

}
