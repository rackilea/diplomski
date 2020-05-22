public void doSomething(String something, Consumer<ErrorResult> errorHandler) {

    //do some stuff
    if(errorHappened) {
        //call the error handler with a new ErrorResult object
        errorHandler.accept(new ErrorResult(...)); 
    }
}