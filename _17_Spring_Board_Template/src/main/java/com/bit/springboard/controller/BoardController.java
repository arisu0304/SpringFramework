package com.bit.springboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/board")
public class BoardController {

    @RequestMapping(value = "/free-list.do", method = RequestMethod.GET)
    public String freeListView(){
        return "board/free-list";
    }

    @RequestMapping(value = "/notice-list.do", method = RequestMethod.GET)
    public String noticeListView(){
        return "board/notice-list";
    }

    @RequestMapping(value = "/notice-detail.do", method = RequestMethod.GET)
    public String noticeDetailView(){
        return "board/notice-detail";
    }

    @RequestMapping(value = "/free-detail.do", method = RequestMethod.GET)
    public String freeDetailView(){
        return "board/free-detail";
    }

    @RequestMapping(value = "/post.do", method = RequestMethod.GET)
    public String postView(){
        return "board/post";
    }

}
