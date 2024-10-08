package com.learn.webservices.restful_web_services.social_media_restful_api;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post,Integer> {
	public List<Post> findByUserId(Integer userId);
}
