catch(SessionException e) {
    Throwable cause = e.getCause();
    while(cause != null) {
        if(cause instanceof NetworkException.class) {
            //Trigger some logic
        }
        else if(...)
        cause = cause.getCause();
    }
}