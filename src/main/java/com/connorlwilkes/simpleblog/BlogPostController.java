package com.connorlwilkes.simpleblog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class BlogPostController {

    @Autowired
    private BlogPostRepository blogPostRepository;

    @GetMapping("/blogPosts")
    public Page<BlogPost> getAllBlogPosts(Pageable pageable) {
        return blogPostRepository.findAll(pageable);
    }

    @PostMapping("/blogPost")
    public BlogPost createBlogPost(@Valid @RequestBody BlogPost blogPost) {
        return blogPostRepository.save(blogPost);
    }

    @PutMapping("/blogPost/{id}")
    public BlogPost updateBlogPost(@PathVariable long id, @Valid @RequestBody BlogPost newBlogPost) {
        return blogPostRepository.findById(id).map(
                blogPost -> {
                    blogPost.setContent(newBlogPost.getContent());
                    return blogPostRepository.save(blogPost);
                }
        ).orElseThrow(() -> new ResourceNotFoundException("Not found"));
    }

    @DeleteMapping("/blogPost/{id}")
    public ResponseEntity<?> deleteBlogPost(@PathVariable long id) {
        return blogPostRepository.findById(id).map(
                blogPost -> {
                    blogPostRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                }
        ).orElseThrow(() -> new ResourceNotFoundException("Not found"));
    }
}
