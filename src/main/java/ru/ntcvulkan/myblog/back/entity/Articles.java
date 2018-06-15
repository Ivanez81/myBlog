package ru.ntcvulkan.myblog.back.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "blog")
@Data
public class Articles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String article;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

}
