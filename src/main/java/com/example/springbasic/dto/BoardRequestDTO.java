package com.example.springbasic.dto;

import lombok.*;

@Getter
@Setter
public class BoardRequestDTO {
    private String title;
    private String content;
    private String writer;

    public BoardRequestDTO(String title, String content, String writer) {
        this.title = title;
        this.content = content;
        this.writer = writer;
    }
}
