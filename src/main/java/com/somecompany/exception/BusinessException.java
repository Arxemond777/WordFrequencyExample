package com.somecompany.exception;

/**
 * Just a custom exception which can be expanded later for some additional business purposes
 *
 * @author <a href="mailto:1arxemond1@gmail.com">Iurii Glushenkov</a>
 */
public class BusinessException extends Exception {
    public BusinessException(String errorMessage) {
        super(errorMessage);
    }
}
