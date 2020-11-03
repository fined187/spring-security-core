package com.aaron.controller;

import com.aaron.domain.MemberDto;
import com.aaron.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping(value="/members")
    public String createUser(){
        return "user/login/register";
    }

    @PostMapping("/members")
    String signUp(MemberDto memberDto) {
        memberService.registerMember(memberDto);
        return "redirect:/";
    }

    @GetMapping(value="/mypage")
    public String myPage(){
        return "user/mypage";
    }
}
