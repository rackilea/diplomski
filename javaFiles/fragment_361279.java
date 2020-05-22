import org.junit.rules.ExpectedException;

<...>

@Rule
public ExpectedException thrown = ExpectedException.none();

@Theory
public void throwExceptionIfArgumentIsIllegal(Type type) throws Exception {
    assumeThat(type, equalTo(ILLEGAL));
    thrown.expect(IllegalArgumentException.class);
    //perform actions
}