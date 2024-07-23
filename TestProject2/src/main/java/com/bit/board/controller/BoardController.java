package com.bit.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {

    @GetMapping("/free-list.do")
        public String boardList() {
        return "board/free-list";
    }

    @GetMapping("/free-detail.do")
    public String boardDetail(){
        return "board/free-detail";
    }

    @GetMapping("/notice-list.do")
    public String noticeList(){
        return "board/notice-list";
    }

    @GetMapping("/notice-detail.do")
    public String noticeDetail(){
        return "board/notice-detail";
    }

    @GetMapping("/post.do")
    public String post(){
        return "board/post";
    }

}
