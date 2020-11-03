package com.aaron.security.provider;

import com.aaron.domain.MemberContext;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@RequiredArgsConstructor
public class CustomAuthenticationProvider implements AuthenticationProvider {

    private final UserDetailsService userDetailsService;

    private final PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        // authentication 이곳에 사용자가 입력한 id, pw 있음
        String name = authentication.getName();
        String password = (String) authentication.getCredentials();

        // userDetailsService 이용해서 MemberContext 가져옴
        MemberContext memberContext = (MemberContext) userDetailsService.loadUserByUsername(name);

        // 패스워드 확인
        if (!passwordEncoder.matches(password, memberContext.getMember().getPassword())) {
            throw new BadCredentialsException("BadCredentialsException");
        }

        return new UsernamePasswordAuthenticationToken(memberContext.getMember(), null,
                memberContext.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
