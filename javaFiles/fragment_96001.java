@Target(value = ElementType.FIELD)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
    Class<? extends Enum<?>> enumClass(); 
    String[] disallowedValues();
}