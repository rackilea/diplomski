public @interface ValidCollection {

    Class<?> elementType();

    /* Specify constraints when collection element type is NOT constrained 
     * validator.getConstraintsForClass(elementType).isBeanConstrained(); */
    Class<?>[] constraints() default {};

    boolean allViolationMessages() default true;

    String message() default "{ValidCollection.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}