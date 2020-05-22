try {
  doSomethingThatThrows(); 
  fail("method should throw");
} catch (SpecificException e) {
  // ensure that e was thrown from the right code-path
  // especially important if it's something as frequent
  // as an IllegalArgumentException, etc.
  assertThat(e).hasMessage("blah blah blah");
}