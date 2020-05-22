public ResponseEntity handle(Exception e, Locale locale) {
        CustomError customError = new CustomError();
        customError.setHttpStatus(HttpStatus.BAD_REQUEST);
        customError.setMessage(resolveExceptionToMessage(e));
        customError.setOriginalException(e);
        return new ResponseEntity<Object>(customError, new HttpHeaders(), 
                      customError.getStatus());
}