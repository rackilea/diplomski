package de.scrum_master.app;

public class BaseError {
    private Exception e;

    public BaseError(Exception e) {
        this.e= e;
    }

    public String getMessage() {
        return e.getMessage();
    }
}