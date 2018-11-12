package com.skilldistillery.NovEventTracker.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="comment")
public class Comment {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id; 

	private String comment;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", comment=" + comment + "]";
	}

	public Comment(int id, String comment) {
		super();
		this.id = id;
		this.comment = comment;
	} 
	
//	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
//	@JoinColumn(name = "content_id")
//	private Content content;
	
	public Comment() {
		
	}
}
