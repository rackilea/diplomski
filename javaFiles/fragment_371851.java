@Test
public void testRegex() {
    final String regex = "\\s*.+\\s*";
    assertTrue(Pattern.matches(regex, "Hello World"));
    assertTrue(Pattern.matches(regex, " Hello World"));
    assertTrue(Pattern.matches(regex, " Hello World "));
    assertTrue(Pattern.matches(regex, "Hello World "));
    assertTrue(Pattern.matches(regex, "  "));
}