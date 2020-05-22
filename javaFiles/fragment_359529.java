@ExceptionHandler(Exception.class)
    protected ResponseEntity<Object> handleConflict(Exception ex, WebRequest request) {
        ErrorResponseDTO errorDTO = new ErrorResponseDTO();
        errorDTO.setErrorMessage("This should be application specific");
        return new ResponseEntity<>(errorDTO, HttpStatus.INTERNAL_SERVER_ERROR);
    }