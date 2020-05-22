@Test
public void testPrint() {
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    //redirect the System-output (normaly the console) to a variable
    System.setErr(new PrintStream(outContent));

    //call your method here

    //check if your error message is in the output variable
    assertEquals("your output", outContent.toString());
}