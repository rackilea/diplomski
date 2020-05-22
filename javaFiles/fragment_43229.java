@Test
public final void testExecute() throws InvalidSyntaxException {
    Assume.assumeTrue(precondition);  // Further execution will be skipped if precondition holds false
    CommandResult result = sentence.getCommand().execute();
    boolean status = Boolean.parseBoolean(result.getResult());
    Assert.assertTrue(status);
}

@Test(expected = InvalidSyntaxException.class)
public final void testInvalidParse() throws InvalidSyntaxException {
    Assume.assumeTrue(!precondition);
    CommandResult result = sentence.getCommand().execute();
}