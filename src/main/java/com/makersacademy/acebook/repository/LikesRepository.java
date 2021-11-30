package com.makersacademy.acebook.repository;

import com.makersacademy.acebook.model.Likes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LikesRepository extends JpaRepository<Likes, UUID> {
}
