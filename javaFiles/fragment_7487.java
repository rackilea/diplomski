@Target({ElementType.TYPE}) 
@Retention(RetentionPolicy.RUNTIME) 
@Constraint(validatedBy=YourDateValidator.class) 
public @interface ValidDates {
    String message() default "{message.id}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}