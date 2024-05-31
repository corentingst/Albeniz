package com.theodo.Albeniz.Exceptions;

public class UnknownMusicId extends RuntimeException {
    public UnknownMusicId (String errorMessage) {
        super(errorMessage);
    }
}
