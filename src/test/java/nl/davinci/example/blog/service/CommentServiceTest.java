package nl.davinci.example.blog.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import nl.davinci.example.blog.model.Post;
import nl.davinci.example.blog.model.dto.CommentDto;
import nl.davinci.example.blog.model.dto.NewCommentDto;
import nl.davinci.example.blog.repository.PostRepository;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.notNullValue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommentServiceTest {

	@Autowired
	PostRepository postRepository;

	@Autowired
	CommentService commentService;

	@Test
	public void shouldAddComment() {
		Post post = createTestPost();

		NewCommentDto comment = new NewCommentDto();
		comment.setPostId(post.getId());
		comment.setAuthor("Author");
		comment.setContent("Content");
		Long commentId = commentService.addComment(comment);

		assertThat("Comment id shouldn't be null", commentId, notNullValue());
	}

	private Post createTestPost() {
		Post post = new Post();
		post.setTitle("Test title");
		post.setContent("Test content");
		LocalDateTime creationDate = LocalDateTime.of(2018, 5, 20, 20, 51, 16);
		post.setCreationDate(creationDate);
		postRepository.save(post);
		return post;
	}

	@Test
	public void shouldReturnAddedComment() {
		Post post = createTestPost();

		NewCommentDto comment = new NewCommentDto();
		comment.setPostId(post.getId());
		comment.setAuthor("Author");
		comment.setContent("Content");

		commentService.addComment(comment);

		List<CommentDto> comments = commentService.getCommentsForPost(post.getId());

		assertThat("There should be one comment", comments, hasSize(1));
		assertThat(comments.get(0).getAuthor(), equalTo("Author"));
		assertThat(comments.get(0).getComment(), equalTo("Content"));
	}
}