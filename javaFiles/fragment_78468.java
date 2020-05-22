@Test
public void test() {
    Validator v = Validation.byProvider( HibernateValidator.class )
            .configure()
            .buildValidatorFactory()
            .getValidator();

    // validations for each group - shows only corresponding violations even if other constraints
    // are violated as well
    assertThat( v.validate( new Bar( null, null ), First.class ) ).hasSize( 2 );
    assertThat( v.validate( new Bar( "", "" ), Second.class ) ).hasSize( 2 );
    assertThat( v.validate( new Bar( "a", "a" ), Third.class ) ).hasSize( 2 );

    // shows that validation will go group by group as defined in the sequence:
    //NotNull
    Set<ConstraintViolation<Bar>> violations = v.validate( new Bar( null, null ) );
    assertThat( violations ).hasSize( 2 );
    assertThat( violations ).extracting( "message" ).containsOnly( "must not be null" );

    //NotBlank
    violations = v.validate( new Bar( "", "" ) );
    assertThat( violations ).hasSize( 2 );
    assertThat( violations ).extracting( "message" ).containsOnly( "must not be blank" );

    //Size
    violations = v.validate( new Bar( "a", "a" ) );
    assertThat( violations ).hasSize( 2 );
    assertThat( violations ).extracting( "message" ).containsOnly( "size must be between 5 and 2147483647" );

}

@GroupSequence({ First.class, Second.class, Third.class, Bar.class })
private static class Bar {

    @NotNull(groups = First.class)
    @NotBlank(groups = Second.class)
    @Size(min = 5, groups = Third.class)
    private final String login;

    @NotNull(groups = First.class)
    @NotBlank(groups = Second.class)
    @Size(min = 5, groups = Third.class)
    private final String password;

    public Bar(String login, String password) {
        this.login = login;
        this.password = password;
    }
}

interface First {
}

interface Second {
}

interface Third {
}