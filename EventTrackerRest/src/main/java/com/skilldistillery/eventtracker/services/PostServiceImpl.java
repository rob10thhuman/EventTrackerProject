package com.skilldistillery.eventtracker.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.eventtracker.repositiories.PostRepository;

@Service
public class PostServiceImpl implements PostService {
	@Autowired
	private PostRepository pRepo; 

	@Override
	public List<Post> findAll() {
		return pRepo.findAll();
	}

}
