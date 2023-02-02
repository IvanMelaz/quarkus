package org.telesoccorso.exception;

public class TscException extends RuntimeException {

    public TscException(Exception e) {
        super(e);
    }

    public TscException(String errorMessage) {
        super(errorMessage);
    }

}
