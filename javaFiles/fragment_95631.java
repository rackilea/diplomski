@Test
public void testWriteFile() throws SQLException {
    TextBuddy  tb = new TextBuddy ();
    tb.writeFile("file.txt", "hello");
    File f = new File("file.txt");
    String content = readFile(f);
    assertThat(content,is("hello"));
}