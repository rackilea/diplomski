@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface EntityResultSet
{
    /**
     * The name of the result set
     * 
     * @return
     */
    String name();

    /**
     * The {@link FieldResult} to override those of the {@link Column}s on the
     * current {@link Entity}
     * 
     * @return
     */
    FieldResult[] fields() default {};

    /**
     * The {@link EntityResult} that define related {@link Entity}s that are
     * included in this result set.
     * 
     * </p>Note: discriminatorColumn has no impact in this usage
     * 
     * @return
     */
    EntityResult[] relatedEntities() default {};
}