package de.scrum_master.app;

public class ExceptionHandler {
    public static BaseError errorResponse(Exception e) {
        return new BaseError(e);
    }
}