public ResponseEntity<CommonResponseObject > saveSomething (Object something) {
    boolean saved = save(something); //save logic
    if(saved)
        return new ResponseEntity<>(new CommonResponseObject(okObject),HttpStatus.OK);
    else
        return new ResponseEntity<>(new CommonResponseObject(errorObject),HttpStatus.FAILED); 
}