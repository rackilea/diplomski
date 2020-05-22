@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface IsCrossSellingRevelant
{
  boolean value() default true;
}