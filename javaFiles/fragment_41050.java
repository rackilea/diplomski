@ControllerAdvice
class MyErrorAdvice {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) //Response Code your want to return
    @ExceptionHandler({MovieNotFoundException.class})
    public void handleMovieNotFoundException(MovieNotFoundException e) {
        log.error("Exception : ", e);
        // Options lines 
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({MyOtherException.class})
    public void handleMyOtherException(MyOtherException e) {
        log.error("Exception : ", e);
        // Options lines 
    }
}