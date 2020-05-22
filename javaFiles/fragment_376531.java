@Target(FIELD)
@Retention(RUNTIME)
@Constraint(validatedBy = {})
@Documented
@ConstraintComposition(OR)
@Email
@Pattern("...")
public @interface Username {
   /* ... */
}