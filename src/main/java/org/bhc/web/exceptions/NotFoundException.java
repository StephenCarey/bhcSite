package org.bhc.web.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {

    Logger logger = LoggerFactory.getLogger(NotFoundException.class);

    public NotFoundException() {
    }

    public NotFoundException(Throwable cause) {
        super(cause);
        logger.info("404 Error ");
    }
}
