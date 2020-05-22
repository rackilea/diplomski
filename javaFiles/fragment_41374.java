@ExceptionHandler(CustomException.class)
    public ResponseEntity<List<ErrorOutDTO>> validationExceptionHandler(CustomException exception) {
        List<ErrorOutDTO> list = new ArrayList<>();
        ErrorOutDTO error = new ErrorOutDTO();
        error.setField(exception.getField());
        error.setMessage(exception.getMessage());
        list.add(error);
        return (ResponseEntity<List<ErrorOutDTO>>)new ResponseEntity(list, HttpStatus.CONFLICT);
    }