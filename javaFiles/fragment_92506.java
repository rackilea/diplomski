@Test
public void someMethodThatThrowsCustomException() {
    expectedException.expect(UniformInterfaceException.class);
    expectedException.expect(UniformInterfaceExceptionMatcher.hasStatus(404));

    ....
}