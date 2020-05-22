@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RUNTIME)
@Constraint(validatedBy = AddressValidator.class)
@Documented
public @interface Address {

    String message() default "Address required";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}