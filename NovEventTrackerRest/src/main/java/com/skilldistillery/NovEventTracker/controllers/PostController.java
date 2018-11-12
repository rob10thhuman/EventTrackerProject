package com.skilldistillery.NovEventTracker.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.NovEventTracker.data.PostDAO;
import com.skilldistillery.NovEventTracker.entities.Post;
import com.skilldistillery.NovEventTracker.services.PostService;

@RestController
@RequestMapping(path="api")
public class PostController {
	@Autowired
	private PostService pSvc; 
	
	@Autowired 
	private PostDAO postDAO; 
	
	@RequestMapping(path="ping", method=RequestMethod.GET)
	public String ping() { 
		return "pong is the man - pong is the legend - pong...IS"; 
	}
	
	@RequestMapping(path="posts", method=RequestMethod.GET)
	public List<Post> getAllPosts() { 
		return pSvc.findAll(); 
	}
	
	@RequestMapping(path="posts/{id}", method=RequestMethod.GET)
	public Optional<Post> show(@PathVariable Integer id) { 
//		List<Post> posts = null; -- useless 
		return pSvc.findByPostId(id); 
	}
	
	//the method I knew 
	@RequestMapping(path="posts", method=RequestMethod.POST)
	public Post create(@RequestBody Post post) {
		post = postDAO.create(post);
		return post; 
	}
	
	//the method we learned 
	@RequestMapping(path="posts/rest", method=RequestMethod.POST)
	public Post createRestPost(@RequestBody Post post) {
		return pSvc.create(post); 
	}
	
	@DeleteMapping(path="posts/{id}")
	public boolean destroy(@PathVariable("id") Integer id) {
		return pSvc.deleteById(id); 
		
	}
	
	@PatchMapping("post/{id}")
	public Post update(@RequestBody Post post, @PathVariable("id") Integer id) {
		pSvc.updatePost(post, id); 
		return post;
		
	}
	
	
}
