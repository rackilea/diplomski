assertTrue(isExpectedConstraintViolated(NotBlank.class, constraintViolations))



public void isExpectedConstraintViolated(Class<?> clazz, Set<ConstraintViolation<Rule>> constraintViolations){
    for(ConstraintViolation<Rule> violaton: constraintViolations){
        if(clazz.equals(violaton.getConstraintDescriptor().getAnnotation().annotationType())){
            return true;
        }
    }
    return false;
}