package com.naumenco.blog.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
public class Post {
    public Post(String title, String anons, String fullText) {
        this.title = title;
        this.anons = anons;
        this.fullText = fullText;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
   private String title,anons,fullText;
   private int views;



}
