package com.example.springbasic.mapper;
import com.example.springbasic.entity.Board;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    List<Board> findAllBoards();
    Board findBoardById(int id);
    void insertBoard(Board board);
    void updateBoard(Board board);
    void deleteBoard(int id);
}
