package com.makersacademy.acebook.repository;

import com.makersacademy.acebook.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CommentRepository extends JpaRepository<Comment, UUID> {
    List<Comment> findByPostID(UUID postID);
}
