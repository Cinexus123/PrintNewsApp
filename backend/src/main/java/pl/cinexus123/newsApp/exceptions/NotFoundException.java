package pl.cinexus123.newsApp.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Not found")
public class NotFoundException extends RuntimeException {

	@Override
	public synchronized Throwable fillInStackTrace() {
		return this;
	}

}
