package com.aaron.repository;

import com.aaron.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    //Member findByAge(int age);

    //@Query("select m from Member m where m.username = :username")
    Optional<Member> findByUsername(String username);
    // select * from member where username = 'sskim'; SQL
    // select m from Member m where m.username = 'sskim'; JPQL
}