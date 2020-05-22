if (check.hasErrors()){

    List<ObjectError> errors = checkMe.getAllErrors();
    assertEquals(1, errors.size());

    FieldError tester = null;
    if (errors.get(0) instanceof FieldError) {
        tester = errors.get(0);
    } else {
        assertFail("Wrong binding result error type.");
    }

    assertEquals("daysToComplete", tester.getField());
    assertEquals("Range", tester.getCode());
    assertEquals("must be between 0 and 365", tester.getDefaultMessage());          
}