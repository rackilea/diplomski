@Test
public void loadAllPropsIncludingCommented() throws Exception {

    // check properties commented not retrieved
    Properties properties = new Properties();
    properties.load(LoadCommentedProp.class.getResourceAsStream("/myProp.properties"));
    Assert.assertEquals("woof", properties.get("dog"));
    Assert.assertNull(properties.get("cat"));

    // action
    BufferedReader bufferedIs = new BufferedReader(new FileReader(LoadCommentedProp.class.getResource("/myProp.properties").getFile()));
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    String currentLine = null;
    while ((currentLine = bufferedIs.readLine()) != null) {
        currentLine = currentLine.replaceFirst("^(#)+", "");
        out.write((currentLine + "\n").getBytes());
    }
    bufferedIs.close();
    out.close();

    // assertion
    ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray());
    properties = new Properties();
    properties.load(in);
    Assert.assertEquals("woof", properties.get("dog"));
    Assert.assertEquals("meow", properties.get("cat"));
}