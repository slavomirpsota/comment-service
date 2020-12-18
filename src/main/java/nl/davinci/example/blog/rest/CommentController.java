package nl.davinci.example.blog.rest;

import java.util.List;
import nl.davinci.example.blog.model.dto.CommentDto;
import nl.davinci.example.blog.model.dto.NewCommentDto;
import nl.davinci.example.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@RequestMapping("/posts")
public class CommentController {

  private final CommentService commentService;

  @Autowired
  CommentController(CommentService commentService) {
    this.commentService = commentService;
  }

  @GetMapping("/{id}/comments")
  @ResponseStatus(HttpStatus.OK)
  public List<CommentDto> getComments(@PathVariable Long id) {
    return commentService.getCommentsForPost(id);
  }

  @PostMapping("/{id}/comments")
  @ResponseStatus(HttpStatus.CREATED)
  public void addComments(NewCommentDto newCommentDto) {
    commentService.addComment(newCommentDto);
  }
}
