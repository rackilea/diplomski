@Test
public void test_firstAndLastName_success() {
  Pattern ptrn = Pattern.compile("(\\w+)\\s+(\\w+)");
  Matcher matcher = ptrn.matcher("FirstName  LastName");
  if (matcher.find()) {
    Assert.assertEquals("FirstName", matcher.group(1));
    Assert.assertEquals("LastName", matcher.group(2));
  } else {
    Assert.fail();
  }
}