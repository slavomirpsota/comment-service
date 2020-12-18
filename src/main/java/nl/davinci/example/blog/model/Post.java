package nl.davinci.example.blog.model;

import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;
import javax.persistence.OneToMany;
import nl.davinci.example.blog.model.dto.CommentDto;
import org.hibernate.annotations.Proxy;

@Entity
@Proxy(lazy = false)
public class Post {

	@Id
	@GeneratedValue
	private Long id;

	private String title;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "post")
	private List<Comment> comments;

	@Column(length = 4096)
	private String content;

	private LocalDateTime creationDate;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	public Long getId() {
		return id;
	}

	public List<Comment> getComments() { return comments; }

	public void setComments(List<Comment> comments) { this.comments = comments; }

}
