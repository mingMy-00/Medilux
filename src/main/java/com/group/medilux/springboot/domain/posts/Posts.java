package com.group.medilux.springboot.domain.posts;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


//Entity => 테이블과 링크될 클래스
//GeneratedValue => pk의 생성규칙
@NoArgsConstructor
@Getter
@Entity
public class Posts {

    //pk필드
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT" , nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author) {
        this.title      = title;
        this.content    = content;
        this.author     = author;
    }
}
