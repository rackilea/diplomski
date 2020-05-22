@Target({FIELD, PARAMETER})
@Retention(RUNTIME)
@Constraint(validatedBy = FutureCustom.class)
public @interface FutureCustom {
    public abstract String max() default "";
    public abstract String message() default "Message";
    public abstract Class<?>[] groups() default {};
    public abstract Class<? extends Payload>[] payload() default {};
}