@Test
public void testThing() {
    final ByteArrayOutputStream out = new ByteArrayOutputStream();
    System.setOut(new PrintStream(out));

    ClassToTest.testMethod(/* desired input */);

    final String written = out.toString();

    Assert.assertEquals(expected, written);
}