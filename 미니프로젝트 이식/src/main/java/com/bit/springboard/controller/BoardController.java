package com.bit.springboard.controller;

import com.bit.springboard.dto.BoardDto;
import com.bit.springboard.dto.MemberDto;
import com.bit.springboard.service.BoardService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/board")
public class BoardController {
    private BoardService boardService;
    private ApplicationContext applicationContext;

    @Autowired
    public BoardController(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @GetMapping("/free-list.do")
    public String freeListView(@RequestParam(defaultValue = "1") int page, Model model) {

        int limit = 10;
        int offset = (page - 1) * limit;

        boardService = applicationContext.getBean("freeBoardServiceImpl", BoardService.class);

        model.addAttribute("freeBoardList", boardService.getBoardList(offset));

        int totalBoardCount = boardService.getBoardCount();
        int totalPages = (int) Math.ceil(totalBoardCount / (double) limit);

        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);

        return "board/free-list";
    }

    @GetMapping("/free-detail.do")
    public String freeDetailView(/*HttpServletRequest request*//*@RequestParam("id") int id*/BoardDto boardDto, Model model) {
//        int id = Integer.valueOf(request.getParameter("id"));
        boardService = applicationContext.getBean("freeBoardServiceImpl", BoardService.class);

        boardService.increaseCnt(boardDto.getId());

        model.addAttribute("freeBoard", boardService.getBoard(boardDto.getId()));

        return "board/free-detail";
    }

    @GetMapping("/notice-list.do")
    public String noticeListView(Model model) {
        boardService = applicationContext.getBean("noticeServiceImpl", BoardService.class);

        model.addAttribute("noticeList", boardService.getBoardList());

        return "board/notice-list";
    }

    @GetMapping("/notice-detail.do")
    public String noticeDetailView(@RequestParam int id, Model model) {

        boardService = applicationContext.getBean("noticeServiceImpl", BoardService.class);

        boardService.increaseCnt(id);

        model.addAttribute("notice", boardService.getBoard(id));

        return "board/notice-detail";
    }

    @GetMapping("/post.do")
    public String postView(HttpSession session) {
        MemberDto loginMember = (MemberDto) session.getAttribute("loginMember");

        if(loginMember == null) {
            return "redirect:/member/login.do";
        }

        return "board/post";
    }

    @PostMapping("/post.do")
    public String post(BoardDto boardDto) {
        // 게시판 타입에 따른 동적 의존성 주입
        if(boardDto.getType().equals("free")) {
            boardService = applicationContext.getBean("freeBoardServiceImpl", BoardService.class);
        } else {
            boardService = applicationContext.getBean("noticeServiceImpl", BoardService.class);
        }

        boardService.post(boardDto);

        if(boardDto.getType().equals("free")) {
            return "redirect:/board/free-list.do";
        } else {
            return "redirect:/board/notice-list.do";
        }
    }

    @PostMapping("/modify.do")
    public String modify(BoardDto boardDto) {
        if(boardDto.getType().equals("free")) {
            boardService = applicationContext.getBean("freeBoardServiceImpl", BoardService.class);
            boardService.modify(boardDto);
            return "redirect:/board/free-detail.do?id=" + boardDto.getId();
        }else{
            boardService = applicationContext.getBean("noticeServiceImpl", BoardService.class);
            boardService.modify(boardDto);
            return "redirect:/board/notice-detail.do?id=" + boardDto.getId();
        }
    }

    @GetMapping("/deleteBoard.do")
    public String deleteBoard(@RequestParam int id, String type){
        if(type.equals("free")){
            boardService = applicationContext.getBean("freeBoardServiceImpl", BoardService.class);
            boardService.delete(id);
            return "redirect:/board/free-list.do";
        }else{
            boardService = applicationContext.getBean("noticeServiceImpl", BoardService.class);
            boardService.delete(id);
            return "redirect:/board/notice-list.do";
        }
    }

}
