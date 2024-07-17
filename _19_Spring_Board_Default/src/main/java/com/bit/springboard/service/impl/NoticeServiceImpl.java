package com.bit.springboard.service.impl;

import com.bit.springboard.dao.NoticeDao;
import com.bit.springboard.dto.BoardDto;
import com.bit.springboard.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeServiceImpl implements BoardService {
    private NoticeDao noticeDao;

    @Autowired
    public NoticeServiceImpl(NoticeDao noticeDao) {
        this.noticeDao = noticeDao;
    }

    @Override
    public void post(BoardDto boardDto) {
        noticeDao.post(boardDto);
    }

    @Override
    public void modify(BoardDto boardDto) {
        noticeDao.modify(boardDto);
    }

    @Override
    public void delete(int id) {
        noticeDao.delete(id);
    }

    @Override
    public List<BoardDto> getBoardList() {
        return noticeDao.getNoticeList();
    }

    @Override
    public List<BoardDto> getBoardList(int offset) {
        return null;
    }

    @Override
    public BoardDto getBoard(int id) {
        return noticeDao.getNotice(id);
    }

    @Override
    public int getBoardCount() {
        return noticeDao.getBoardCount();
    }

    @Override
    public void increaseCnt(int id) {
        noticeDao.increaseCnt(id);
    }
}
