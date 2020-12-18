package nl.davinci.example.blog.service;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;
import nl.davinci.example.blog.model.Post;
import nl.davinci.example.blog.model.dto.CommentDto;
import nl.davinci.example.blog.model.dto.NewCommentDto;
import org.springframework.stereotype.Service;

import nl.davinci.example.blog.model.dto.PostDto;
import nl.davinci.example.blog.repository.PostRepository;

@Service
public class PostService {

	private final PostRepository postRepository;

	public PostService(PostRepository postRepository) {
		this.postRepository = postRepository;
	}

	public PostDto getPost(Long id) {
		return postRepository.findById(id)
				.map(post -> new PostDto(post.getTitle(), post.getContent(), post.getCreationDate()))
				.orElse(null);
	}
}
