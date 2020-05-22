@Test
public void defConstructorTest() {
    Man m = new Man();
    assertNull(m.getName());
    assertEquals(0, m.getBorn());
}