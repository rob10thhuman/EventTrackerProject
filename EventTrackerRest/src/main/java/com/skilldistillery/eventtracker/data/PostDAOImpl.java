package com.skilldistillery.eventtracker.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import com.skilldistillery.EventTrackerProject.entities.Post;


import org.springframework.stereotype.Service;

@Transactional
@Service
public class PostDAOImpl implements PostDAO {
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Post> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
