package com.connorlwilkes.simpleblog;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity(name = "BlogPosts")
@Table(name = "blog_posts")
@EntityListeners(AuditingEntityListener.class)
public class BlogPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "blog_post_id")
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false)
    @CreatedDate
    private Date timeStamp;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at", nullable = false)
    @LastModifiedDate
    private Date updatedAt;

    @Column(name = "content")
    private String content;

    @Column(name = "title")
    private String title;

    @ToString.Exclude
    @JsonManagedReference
    @OneToMany(mappedBy = "blogPost", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments = new ArrayList<>();

    protected BlogPost() {
    }

    public void addComment(Comment comment) {
        this.comments.add(comment);
        comment.setBlogPost(this);
    }

    public void removeComment(Comment comment) {
        this.comments.remove(comment);
        comment.setBlogPost(null);
    }
}
