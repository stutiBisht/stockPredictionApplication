package com.investment.stockPrediction.common;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.RollbackException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpStatusCodeException;

@ControllerAdvice
public class ErrorControllerAdvice {

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<Object> exception(Exception exception) {
		Error error = new Error();
		if ((exception.getCause()) instanceof ApplicationValidationException) {
			ApplicationValidationException applicationValidationException = (ApplicationValidationException) (exception
					.getCause());
			return new ResponseEntity<>(applicationValidationException.getErrors(), HttpStatus.BAD_REQUEST);
		} else if ((exception.getCause()) instanceof HttpStatusCodeException) {
			HttpStatusCodeException httpStatusCodeException = (HttpStatusCodeException) (exception.getCause());
			error.setMessage(httpStatusCodeException.getMessage());
			error.setErrorType("Bad Request");
			error.setStatusCode("400");
			return new ResponseEntity<>(httpStatusCodeException.getMessage(), httpStatusCodeException.getStatusCode());
		} else if ((exception.getCause()) instanceof MethodArgumentNotValidException) {
			MethodArgumentNotValidException methodArgumentNotValidException = (MethodArgumentNotValidException) (exception
					.getCause());
			Map<String, String> errors = new HashMap<>();
			methodArgumentNotValidException.getBindingResult().getAllErrors().forEach((er) -> {
				String fieldName = ((FieldError) er).getField();
				String errorMessage = er.getDefaultMessage();
				errors.put(fieldName, errorMessage);
			});
			return new ResponseEntity<>("Request failed due to validation error --> " + errors, HttpStatus.BAD_REQUEST);
		} else if ((exception.getCause()) instanceof RollbackException) {
			return new ResponseEntity<>("Error occured due to null or blank value for NotNull fields in the file.",
					HttpStatus.BAD_REQUEST);
		} else {
			error.setMessage(exception.getMessage());
			error.setErrorType("Bad Request");
			error.setStatusCode("400");
			return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
		}
	}/*
		 * 
		 * @ExceptionHandler(value = PSQLException.class) protected String
		 * pSQLException(HttpServletRequest req, Exception ex) { ModelMap model = new
		 * ModelMap(); model.put("error", ex.getMessage()); return "error"; }
		 */
}
