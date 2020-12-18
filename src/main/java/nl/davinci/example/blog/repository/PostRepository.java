package nl.davinci.example.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import nl.davinci.example.blog.model.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

}
