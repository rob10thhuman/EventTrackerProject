package com.skilldistillery.NovEventTracker.data;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skilldistillery.NovEventTracker.entities.Post;

@Transactional
@Service
public class PostDAOImpl implements PostDAO {
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Post create(Post post) {
		em.persist(post);
		em.flush();
		return post;

	}
	
	


}
