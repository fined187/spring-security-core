package com.aaron.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MessageController {

    @GetMapping(value="/messages")
    public String messages() throws Exception {

        return "user/messages";
    }

//    @PostMapping(value="/api/message")
//    public String messages2() throws Exception {
//        return "user/messages";
//    }
}