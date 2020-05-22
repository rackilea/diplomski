@Test
public void testConversion() throws Exception {
    ByteArrayOutputStream output = new ByteArrayOutputStream();
    OutputEscapingStreamWriter wrapper = new OutputEscapingStreamWriter(output);
    wrapper.write("\"Русслэнд\";\"Ελλάς\";\"Réunion\"");
    wrapper.flush();
    wrapper.close();
    String result = output.toString();

    assertEquals("\"\\u0420\\u0443\\u0441\\u0441\\u043b\\u044d\\u043d\\u0434\";\"\\u0395\\u03bb\\u03bb\\u03ac\\u03c2\";\"R\\u00e9union\"", 
            result);
}