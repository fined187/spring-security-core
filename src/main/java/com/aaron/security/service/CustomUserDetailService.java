package com.aaron.security.service;

import com.aaron.domain.Member;
import com.aaron.domain.MemberContext;
import com.aaron.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // 실제 DB에서 사용자 정보 가져옴.
        Member findMember = memberRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("UsernameNotFoundException"));


        // Role list 생성
        List<GrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority(findMember.getRole()));

        // MemberContext 생성..
        return new MemberContext(findMember, roles);
    }
}
