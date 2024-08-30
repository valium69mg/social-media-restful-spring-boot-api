package com.learn.webservices.restful_web_services.social_media_restful_api;

import java.time.LocalDate;
import java.util.NoSuchElementException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = { Exception.class })
	public final ResponseEntity<SocialMediaErrorDetails> handleAllException(Exception ex, WebRequest request)
			throws Exception {
		SocialMediaErrorDetails errorDetails = new SocialMediaErrorDetails(LocalDate.now(), ex.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<SocialMediaErrorDetails>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(value = { NoSuchElementException.class })
	public final ResponseEntity<SocialMediaErrorDetails> handleNoSuchElementExceptionException(Exception ex,
			WebRequest request) throws Exception {
		SocialMediaErrorDetails errorDetails = new SocialMediaErrorDetails(LocalDate.now(), ex.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<SocialMediaErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {

		SocialMediaErrorDetails errorDetails = new SocialMediaErrorDetails(LocalDate.now(), ex.getMessage(),
				request.getDescription(false));

		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	}

}
