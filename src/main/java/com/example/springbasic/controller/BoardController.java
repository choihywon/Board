package com.example.springbasic.controller;

import com.example.springbasic.dto.BoardRequestDTO;
import com.example.springbasic.dto.BoardResponseDTO;
import com.example.springbasic.service.BoardService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/boards")
public class BoardController {
    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping
    public List<BoardResponseDTO> getAllBoards() {
        return boardService.getAllBoards();
    }

    @GetMapping("/{id}")
    public BoardResponseDTO getBoardById(@PathVariable int id) {
        return boardService.getBoardById(id);
    }

    @PostMapping
    public void createBoard(@RequestBody BoardRequestDTO requestDto) {
        boardService.createBoard(requestDto);
    }

    @PutMapping("/{id}")
    public void updateBoard(@PathVariable int id, @RequestBody BoardRequestDTO requestDto) {
        boardService.updateBoard(id, requestDto);
    }

    @DeleteMapping("/{id}")
    public void deleteBoard(@PathVariable int id) {
        boardService.deleteBoard(id);
    }
}
