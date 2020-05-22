public enum LogicExpression {
OR,AND,NOT;
}


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.ANNOTATION_TYPE)
public @interface ComposedCondition {
LogicExpression[] getExpressions() default {};
Attributes[] orAttributes() default {};
   Attributes[] andAttributes() default {};..
}