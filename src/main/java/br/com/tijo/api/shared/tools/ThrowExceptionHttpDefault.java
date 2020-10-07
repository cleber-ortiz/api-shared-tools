package br.com.tijo.api.shared.tools;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

import com.google.gson.Gson;

import br.com.tijo.api.shared.tools.exception.BadGatewayException;
import br.com.tijo.api.shared.tools.exception.DuplicatedException;
import br.com.tijo.api.shared.tools.exception.NotFoundException;
import br.com.tijo.api.shared.tools.exception.UnauthorizedException;

public class ThrowExceptionHttpDefault {

	public static void checkExceptions(HttpClientErrorException e) throws DuplicatedException, Exception {
		
		DefaultHttpJsonResponse<Object> error = new DefaultHttpJsonResponse<Object>();
		
		try {
			error = new Gson().fromJson(e.getResponseBodyAsString(), new DefaultHttpJsonResponse<Object>().getClass());
		}
		catch (Exception ex) {
			error.setErrorMessage("Error parsing message");
		}

		if(e.getStatusCode() == HttpStatus.CONFLICT) {
			throw new DuplicatedException(error.getErrorMessage());
		}
		else if(e.getStatusCode() == HttpStatus.BAD_GATEWAY) {
			throw new BadGatewayException(error.getErrorMessage());
		}
		else if(e.getStatusCode() == HttpStatus.BAD_REQUEST) {
			throw new BadGatewayException(error.getErrorMessage());
		}
		else if(e.getStatusCode() == HttpStatus.CONFLICT) {
			throw new DuplicatedException(error.getErrorMessage());
		}
		else if(e.getStatusCode() == HttpStatus.NOT_FOUND) {
			throw new NotFoundException(error.getErrorMessage());
		}
		else if(e.getStatusCode() == HttpStatus.UNAUTHORIZED) {
			throw new UnauthorizedException(error.getErrorMessage());
		}
		else {
			throw new Exception(e.getMessage());
		}
	}
	public static void checkExceptions(HttpServerErrorException e) throws DuplicatedException, Exception {
		DefaultHttpJsonResponse<Object> error = new DefaultHttpJsonResponse<Object>();
		
		try {
			error = new Gson().fromJson(e.getResponseBodyAsString(), new DefaultHttpJsonResponse<Object>().getClass());
		}
		catch (Exception ex) {
			error.setErrorMessage("Error parsing message");
		}
		
		
		if(e.getStatusCode() == HttpStatus.CONFLICT) {
			throw new DuplicatedException(error.getErrorMessage());
		}
		else if(e.getStatusCode() == HttpStatus.BAD_GATEWAY) {
			throw new BadGatewayException(error.getErrorMessage());
		}
		else if(e.getStatusCode() == HttpStatus.BAD_REQUEST) {
			throw new BadGatewayException(error.getErrorMessage());
		}
		else if(e.getStatusCode() == HttpStatus.CONFLICT) {
			throw new DuplicatedException(error.getErrorMessage());
		}
		else if(e.getStatusCode() == HttpStatus.NOT_FOUND) {
			throw new NotFoundException(error.getErrorMessage());
		}
		else if(e.getStatusCode() == HttpStatus.UNAUTHORIZED) {
			throw new UnauthorizedException(error.getErrorMessage());
		}
		else {
			throw new Exception(e.getMessage());
		}
	}
	
}
