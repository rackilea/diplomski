@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@Target({FIELD})
@Inherited
@interface Weight{
    int value();
}