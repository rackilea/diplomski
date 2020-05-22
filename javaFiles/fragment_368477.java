@PostMapping(value = "createTodoContract")
public ResponseEntity<Object> CreateTodoContract(@Valid @RequestBody 
                                                 CreateTodoContract 
                                                 createTodoContractRequest,
                                                 BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
        String error = bindingResult.getAllErrors().get(0).getDefaultMessage();
        return new ResponseEntity<>(responseBuilder.build("02", error), status);
    }

    return new ResponseEntity<>(response, response.getStatus());

}