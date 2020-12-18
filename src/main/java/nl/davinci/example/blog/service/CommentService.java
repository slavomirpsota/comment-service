package nl.davinci.example.blog.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;
import nl.davinci.example.blog.model.Comment;
import nl.davinci.example.blog.model.Post;
import nl.davinci.example.blog.model.dto.PostDto;
import nl.davinci.example.blog.repository.CommentRepository;
import nl.davinci.example.blog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import nl.davinci.example.blog.model.dto.CommentDto;
import nl.davinci.example.blog.model.dto.NewCommentDto;

@Service
public class CommentService {

	@Autowired
	private PostRepository postRepository;
	@Autowired
	private CommentRepository commentRepository;

	/**
	 * Returns a list of all comments for a blog post with passed id.
	 *
	 * @param postId id of the post
	 * @return list of comments sorted by creation date descending - most recent first
	 */
	public List<CommentDto> getCommentsForPost(Long postId) {
		List<Comment> listOfComments =  postRepository.getOne(postId).getComments();
		List<CommentDto> listOfCommentsDto = new ArrayList<>();
		listOfComments.forEach(c -> listOfCommentsDto.add(new CommentDto(c.getId(), c.getContent(), c.getAuthor(), c.getCreationDate())));
		return listOfCommentsDto;
	}

	/**
	 * Creates a new comment
	 *
	 * @param newCommentDto data of new comment
	 * @return id of the created comment
	 *
	 * @throws IllegalArgumentException if there is no blog post for passed newCommentDto.postId
	 */
	public Long addComment(NewCommentDto newCommentDto) {
		Optional<Post> editedPost = postRepository.findById(newCommentDto.getPostId());
		Comment comment = new Comment();
		comment.setPost(editedPost.get());
		comment.setAuthor(newCommentDto.getAuthor());
		comment.setContent(newCommentDto.getContent());
		comment.setCreationDate(LocalDateTime.now());

		return commentRepository.saveAndFlush(comment).getId();
	}
}
