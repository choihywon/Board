package com.example.springbasic.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class BoardResponseDTO {
    private int id;
    private String title;
    private String content;
    private String writer;
    private LocalDateTime createdAt;

    public BoardResponseDTO(int id, String title, String content, String writer, LocalDateTime createdAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.createdAt = createdAt;
    }
}
