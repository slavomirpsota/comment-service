package nl.davinci.example.blog.model.dto;

import java.time.LocalDateTime;
import java.util.List;

public class PostDto {

	private List<CommentDto> comments;

	private String title;

	private String content;

	private LocalDateTime creationDate;

	public PostDto(String title, String content, LocalDateTime creationDate) {
		this.title = title;
		this.content = content;
		this.creationDate = creationDate;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public List<CommentDto> getComments() { return comments; }

	public void addComment(CommentDto comment) { this.comments.add(comment); }
}
