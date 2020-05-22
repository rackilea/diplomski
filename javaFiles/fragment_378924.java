Throwable unrollException(Throwable exception, Class<? extends Throwable> expected){

    while(exception != null && exception != exception.getCause()){
        if(expected.isInstance(exception)){
          return exception;
        }
        exception = exception.getCause();
    }
    return null;
}