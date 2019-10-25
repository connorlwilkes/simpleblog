package com.connorlwilkes.simpleblog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class CommentController {

    @Autowired
    private CommentRepository repository;

    @GetMapping("/getCommentsForBlogPost/{blogId}")
    public List<Comment> getCommentByBlogPost(@PathVariable long id, Pageable pageable) {
        return repository.findByBlogPost(id, pageable);
    }

    @PostMapping("/postCommentToBlogPost/{blogId}")
    public Comment addCommentToBlogPost(@PathVariable long id, @Valid @RequestBody Comment newComment) {
        return repository.save(newComment);
    }
}
