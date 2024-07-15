package com.bit.springboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/member")
public class MemberController {

    @RequestMapping(value = "/join.do", method = RequestMethod.GET)
    public String joinView(){
        return "member/join";
    }

    @RequestMapping(value = "/login.do", method = RequestMethod.GET)
    public String loginView(){
        return "member/login";
    }
}
