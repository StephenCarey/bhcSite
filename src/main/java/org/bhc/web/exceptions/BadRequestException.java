package org.bhc.web.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException {

    Logger logger = LoggerFactory.getLogger(BadRequestException.class);


    public BadRequestException() {
    }

    public BadRequestException(Throwable cause) {
        super(cause);
        logger.info(" Error");
    }
}
