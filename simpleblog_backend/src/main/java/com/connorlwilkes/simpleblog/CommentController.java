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

    @Autowired
    private BlogPostRepository blogPostRepository;

    @GetMapping("/getCommentsForBlogPost/{blogId}")
    public List<Comment> getCommentByBlogPost(@PathVariable long blogId, Pageable pageable) {
        return blogPostRepository.findById(blogId)
                .map(BlogPost::getComments).orElseThrow(() -> new ResourceNotFoundException("No blog post"));
    }

    @PostMapping("/postCommentToBlogPost/{blogId}")
    public Comment addCommentToBlogPost(@PathVariable long blogId, @Valid @RequestBody Comment newComment) {
        return blogPostRepository.findById(blogId).map(blogPost -> {
            newComment.setBlogPost(blogPost);
            return repository.save(newComment);
        }).orElseThrow(() -> new ResourceNotFoundException("No blog post"));
    }
}
