package ru.ntcvulkan.myblog.back.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "blog")
@Data
public class Articles{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Lob
    private String article;

    private LocalDateTime date;

}
