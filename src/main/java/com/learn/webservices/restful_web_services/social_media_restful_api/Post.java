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
	
	public Post(String description) {
		super();
		this.description = description;
	}

	public Integer getId() {
		return postId;
	}

	public void setId(Integer id) {
		this.postId = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Post [postId=" + postId + ", userId=" + userId + ", description=" + description + "]";
	}
	
	
}
