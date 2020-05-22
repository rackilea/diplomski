@Retention(RUNTIME)
@Target(ANNOTATION_TYPE)
public @interface DynamicScope {

    class DefaultActivation implements DynamicContextActivation {

        public boolean isActive(Context context) {
            return true;
        }
    }

    Class<? extends Annotation>[] value();

    Class<? extends DynamicContextActivation> activation() default DefaultActivation.class;
}