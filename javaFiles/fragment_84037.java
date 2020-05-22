@Test
@ClearSystemProperty(key = "some key")
@SetSystemProperty(key = "another key", value = "new value")
void test() {
    assertNull(System.getProperty("some key"));
    assertEquals("new value", System.getProperty("another key"));
}