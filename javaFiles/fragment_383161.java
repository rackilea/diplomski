@ExceptionHandler({ CustomException1.class})
    public ResponseEntity handleException1() {
        return createError(code for this exceptio 1);
    }
    @ExceptionHandler({ CustomException2.class})
    public ResponseEntity handleException2() {
        return createError(code for this exceptio 2);
    }
    private ResponseEntity createError(String errorCode ) {
            CustomError customError = new CustomError();
            customError.setHttpStatus(HttpStatus.BAD_REQUEST);
            String errorMessage = messageSource.getMessage(
                                 errorCode , new Object[]{},locale); 

            customError.setMessage(errorMessage );
            customError.setOriginalException(e);
            return new ResponseEntity<Object>(customError, new HttpHeaders(), 
                          customError.getStatus());
    }