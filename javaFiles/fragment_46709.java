@With({ ArgsAction.class })
@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Args {

    int start() default -1;
    int end() default -1;

}