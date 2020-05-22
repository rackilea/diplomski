public class ListBeanValidationTest {

    public static void main(String[] args) {
        List<Bean> asList = Arrays.asList(new Bean("test"), new Bean("test2"));

        Validator v = Validators.newConfiguration().messageInterpolator(new MsgInterpolator()).buildValidatorFactory().getValidator();

        // this is what DW does but i am lazy so you get the main version
        if(asList instanceof Iterable) {
            Iterable values = (Iterable) asList;
            Set<ConstraintViolation<Object>> violations = new HashSet<>();
            for(Object value : values) {
                violations.addAll(v.validate(value));
            }

            violations.forEach(System.out::println);
        }
    }

    public static class Bean {

        Bean(String name) {
            this.name = name;
        }

        String name;

        @NotEmpty(message="bean not empty ${name}")
        String wrong;
    }

    public static class MsgInterpolator implements MessageInterpolator {

        @Override
        public String interpolate(String messageTemplate, Context context) {
            return interpolate(messageTemplate, context, Locale.getDefault());
        }

        @Override
        public String interpolate(String messageTemplate, Context context, Locale locale) {
            Object validatedValue = context.getValidatedValue();


            return null;
        }

    }
}