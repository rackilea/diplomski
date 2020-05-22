@Target({ElementType.FIELD, ElementType.PARAMETER,ElementType.ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = ValidateListValidator.class)
@Documented
public @interface ValidateList {
}