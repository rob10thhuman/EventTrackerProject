package com.skilldistillery.NovEventTracker.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.NovEventTracker.entities.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {

	Optional<Post> findById(Integer id);

}
