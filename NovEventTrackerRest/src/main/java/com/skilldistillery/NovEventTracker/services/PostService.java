package com.skilldistillery.NovEventTracker.services;

import java.util.List;
import java.util.Optional;

import com.skilldistillery.NovEventTracker.entities.Post;

public interface PostService {

	List<Post> findAll();

	Post create(Post post);

	Optional<Post> findByPostId(int id);

	boolean deleteById(Integer id);

	Post updatePost(Post post, Integer id);

}
