@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE })
@Documented
@Constraint(validatedBy = IpAddressValidator.class)
public @interface IpAddress
{
  String message() default "{ipAddress.invalid}";
  Class<?>[] groups() default {};
  Class<? extends Payload>[] payload() default {};
}