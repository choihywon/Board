package com.example.springbasic.service;
import com.example.springbasic.dto.BoardRequestDTO;
import com.example.springbasic.dto.BoardResponseDTO;
import com.example.springbasic.entity.Board;
import com.example.springbasic.mapper.BoardMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BoardService {
    private final BoardMapper boardMapper;

    public BoardService(BoardMapper boardMapper) {
        this.boardMapper = boardMapper;
    }

    public List<BoardResponseDTO> getAllBoards() {
        return boardMapper.findAllBoards().stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }

    public BoardResponseDTO getBoardById(int id) {
        Board board = boardMapper.findBoardById(id);
        if (board == null) {
            throw new IllegalArgumentException("Board not found with id: " + id);
        }
        return convertToResponseDTO(board);
    }

    public void createBoard(BoardRequestDTO requestDto) {
        Board board = convertToEntity(requestDto);
        boardMapper.insertBoard(board);
    }

    public void updateBoard(int id, BoardRequestDTO requestDto) {
        Board board = boardMapper.findBoardById(id);
        if (board == null) {
            throw new IllegalArgumentException("Board not found with id: " + id);
        }
        board.setTitle(requestDto.getTitle());
        board.setContent(requestDto.getContent());
        boardMapper.updateBoard(board);
    }

    public void deleteBoard(int id) {
        Board board = boardMapper.findBoardById(id);
        if (board == null) {
            throw new IllegalArgumentException("Board not found with id: " + id);
        }
        boardMapper.deleteBoard(id);
    }

    private BoardResponseDTO convertToResponseDTO(Board board) {
        return new BoardResponseDTO(
                board.getId(),
                board.getTitle(),
                board.getContent(),
                board.getWriter(),
                board.getCreatedAt()
        );
    }

    private Board convertToEntity(BoardRequestDTO requestDto) {
        return Board.builder()
                .title(requestDto.getTitle())
                .content(requestDto.getContent())
                .writer(requestDto.getWriter())
                .build();
    }
}
