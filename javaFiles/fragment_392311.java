@Rule
public ExpectedException expectedEx = ExpectedException.none();

@Test
public void test1() throws IOException {
   expectedEx.expect(SomeClass.class);
   expectedEx.expectMessage(matchesRegex("**[123]regexExample*"));
   generatesException();
}

private Matcher<String> matchesRegex(final String regex) {
   return new TypeSafeMatcher<String>() {
     @Override
     protected boolean matchesSafely(final String item) {
        return item.matches(regex);
     }
  };
}