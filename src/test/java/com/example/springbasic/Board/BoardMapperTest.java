package com.example.springbasic.Board;


import com.example.springbasic.entity.Board;
import com.example.springbasic.mapper.BoardMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class BoardMapperTest {

    @Autowired
    private BoardMapper boardMapper;

    @Test
    void testFindAllBoards() {
        List<Board> boards = boardMapper.findAllBoards();
        assertThat(boards).isNotNull();
        assertThat(boards.size()).isGreaterThanOrEqualTo(0);
    }

    @Test
    void testFindBoardById() {
        int testId = 3; // 테스트 데이터의 ID
        Board board = boardMapper.findBoardById(testId);
        assertThat(board).isNotNull();
        assertThat(board.getId()).isEqualTo(testId);
    }

    @Test
    void testInsertBoard() {
        // 데이터 삽입
        Board board = new Board();
        board.setTitle("Test Title");
        board.setContent("Test Content");
        board.setWriter("Test Writer");

        boardMapper.insertBoard(board);

        // 삽입된 데이터 검증
        assertThat(board.getId()).isNotNull(); // ID가 자동 생성되었는지 확인
        Board insertedBoard = boardMapper.findBoardById(board.getId());
        assertThat(insertedBoard).isNotNull();
        assertThat(insertedBoard.getTitle()).isEqualTo("Test Title");
        assertThat(insertedBoard.getContent()).isEqualTo("Test Content");
        assertThat(insertedBoard.getWriter()).isEqualTo("Test Writer");
    }

    @Test
    void testDeleteBoard() {
        int testId = 1; // 테스트 데이터의 ID
        boardMapper.deleteBoard(testId);

        Board deletedBoard = boardMapper.findBoardById(testId);
        assertThat(deletedBoard).isNull();
    }
}