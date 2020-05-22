@Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        List<String> errorMessages = new ArrayList<>();
        BindingResult bindingResult = ex.getBindingResult();
        List<ObjectError> errors = bindingResult.getAllErrors();
        for(ObjectError error : errors) {
            String message = error.getDefaultMessage();
            errorMessages.add(message);
        }

        return new ResponseEntity<>(new Error(errorMessages), new HttpHeaders(), BAD_REQUEST);
    }