package com.learn.webservices.restful_web_services.social_media_restful_api;

public class Personv2 {
	String fullName;

	public Personv2(String fullName) {
		super();
		this.fullName = fullName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	@Override
	public String toString() {
		return "Personv2 [fullName=" + fullName + "]";
	}
	
	
}
