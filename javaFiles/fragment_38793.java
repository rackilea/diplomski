interface ExceptionHandler<T extends Throwable> {

    void handle(T exception);

}

class UnsupportedOperationExceptionHandler implements ExceptionHandler<UnsupportedOperationException> {

    @Override
    public void handle(UnsupportedOperationException exception) {
        //blaa
    }
}

class IllegalArguementExceptionHandler implements ExceptionHandler<IllegalArgumentException> {

    @Override
    public void handle(IllegalArgumentException exception) {
        //blaa part 2
    }
}

class YourHandler {

    private final Map<Class<? extends Throwable>, ExceptionHandler> exceptionHandlers; //This will contain all your handlers

    @Inject
    YourHandler(Map<Class<? extends Throwable>, ExceptionHandler> exceptionHandlers) {
        this.exceptionHandlers = exceptionHandlers;
    }

    public void save() {
        try {
            //some method here.
        } catch (Exception e) {
            exceptionHandlers.get(e.getClass()).handle(e);
        }
    }
}