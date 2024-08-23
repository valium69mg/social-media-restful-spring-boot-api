package com.learn.webservices.restful_web_services.social_media_restful_api;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer postId;
	private Integer userId;
	private String description;
	
	public Post() {
		super();
	}
	
	public Post(Integer userId, String description) {
		super();
		this.userId = userId;
		this.description = description;
	}
	
	public Post(String description) {
		super();
		this.description = description;
	}

	public Integer getPostId() {
		return postId;
	}

	public void setPostId(Integer postId) {
		this.postId = postId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Post [postId=" + postId + ", userId=" + userId + ", description=" + description + "]";
	}
	
	
	
	
}
