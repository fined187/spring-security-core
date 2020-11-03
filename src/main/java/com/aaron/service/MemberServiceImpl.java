package com.aaron.service;

import com.aaron.domain.Member;
import com.aaron.domain.MemberDto;
import com.aaron.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    // SecurityConfig 에서 Bean 등록 함
    private final PasswordEncoder passwordEncoder;

    @Transactional
    @Override
    public void registerMember(MemberDto memberDto) {

        Member member = Member.builder()
                .username(memberDto.getUsername())
                .email(memberDto.getEmail())
                .password(passwordEncoder.encode(memberDto.getPassword()))
                .age(memberDto.getAge())
                .role(memberDto.getRole())
                .build();

        memberRepository.save(member);
    }
}
