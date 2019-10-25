package com.connorlwilkes.simpleblog;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "Comments")
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String author;

    private String content;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "blog_post_id")
    private BlogPost blogPost;

    protected Comment() {
    }

}
