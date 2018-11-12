package com.skilldistillery.NovEventTracker.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.NovEventTracker.entities.Post;
import com.skilldistillery.NovEventTracker.repositories.PostRepository;


@Service
public class PostServiceImpl implements PostService {
	@Autowired
	PostRepository pRepo; 
	
	@Override
	public List<Post> findAll() {
		return pRepo.findAll();
	}
	
	@Override 
	public Post create(Post post) {
		pRepo.saveAndFlush(post); 
		return post; 
	}

	@Override
	public Optional<Post> findByPostId(int id) {	
		Optional<Post> post = null; 
		post = pRepo.findById(id); 
		return post;
	}

	@Override
	public boolean deleteById(Integer id) {
		boolean deleted = false; 
		pRepo.deleteById(id);
		return deleted;
	}

	@Override
	public Post updatePost(Post post, Integer id) {
		Optional<Post> opt = pRepo.findById(id); 
		Post newPost = null; 
		if (opt.isPresent()) {
			newPost = opt.get(); 
		}
		newPost.setTitle(post.getTitle());
		newPost.setHyperlink(post.getHyperlink());
		newPost.setDescription(post.getDescription());
		newPost.setUsername(post.getUsername());
		pRepo.saveAndFlush(newPost);
		return post;
	}	

}
