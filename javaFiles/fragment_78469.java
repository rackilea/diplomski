@Test
public void test2() throws Exception {
    Set<ConstraintViolation<Foo>> violations = validator.validate( new Foo( "", null ) );
    assertThat( violations ).hasSize( 2 );
    assertThat( violations ).extracting( "message" )
            .containsOnly( "value should be between 3 and 30 chars long", "Value cannot be null" );
}

private static class Foo {

    @ValidLogin
    private final String login;

    @ValidLogin
    private final String password;

    public Foo(String login, String password) {
        this.login = login;
        this.password = password;
    }
}

@Target({ FIELD })
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = { ValidLogin.ValidLoginValidator.class })
@interface ValidLogin {
    String message() default "message";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

    class ValidLoginValidator implements ConstraintValidator<ValidLogin, String> {
        private static final Pattern PATTERN = Pattern.compile( "^[a-zA-Z0-9]*$" );

        @Override
        public boolean isValid(String value, ConstraintValidatorContext context) {
            String message = "";
            if ( value == null ) {
                message = "Value cannot be null";
            }
            else if ( !PATTERN.matcher( value ).matches() ) {
                message = "Value should match pattern ";
            }
            else if ( message.length() < 3 || message.length() > 30 ) {
                message = "value should be between 3 and 30 chars long";
            }
            if ( !message.isEmpty() ) {
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate( message ).addConstraintViolation();
            }
            return false;
        }
    }
}