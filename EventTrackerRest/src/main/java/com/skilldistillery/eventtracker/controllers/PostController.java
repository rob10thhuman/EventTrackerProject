package com.skilldistillery.eventtracker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.eventtracker.data.PostDAO;
import com.skilldistillery.eventtracker.services.PostService;
import com.skilldistillery.EventTracker.entities.Post;

@RestController 
@RequestMapping(path="api")
public class PostController {
	@Autowired 
	private PostDAO postDAO; 
	
	@Autowired 
	private PostService pSvc; 
	
	@RequestMapping(path="ping", method=RequestMethod.GET)
	public String ping() { 
		return "pong is the man - pong is the legend - pong...IS"; 
	}
	
	@GetMapping("post")
	public List<Post> index(){
		List<Post> post = null; 
		post = pSvc.findAll(); 
		return post;
		
	}

}
