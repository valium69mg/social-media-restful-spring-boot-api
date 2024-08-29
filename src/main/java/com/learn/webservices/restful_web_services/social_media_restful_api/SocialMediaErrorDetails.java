package com.learn.webservices.restful_web_services.social_media_restful_api;

import java.time.LocalDate;

public class SocialMediaErrorDetails  {
	
	private LocalDate timestamp;
	private String message;
	private String details;
	
	public SocialMediaErrorDetails(LocalDate timestamp, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}
	
	public LocalDate getTimestamp() {
		return timestamp;
	}
	public String getMessage() {
		return message;
	}
	public String getDetails() {
		return details;
	}

	@Override
	public String toString() {
		return "SocialMediaErrorDetails [timestamp=" + timestamp + ", message=" + message + ", details=" + details
				+ "]";
	}
	
}
