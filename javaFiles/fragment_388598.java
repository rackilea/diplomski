public class KeyBufferTest {

  @Test
  public void addSimpleCharacter() {
    KeyBuffer buffer = new KeyBuffer();
    buffer.add("a");
    buffer.add("b");
    buffer.add("c");

    assertEquals("abc", buffer.toString());
  }

  @Test
  public void addUsingArrows() {
    KeyBuffer buffer = new KeyBuffer();
    buffer.add("a");
    buffer.add("b");
    buffer.add("arrow_left");
    buffer.add("c");

    assertEquals("acb", buffer.toString());
  }

  @Test
  public void addBackspace() {
    KeyBuffer buffer = new KeyBuffer();
    buffer.add("a");
    buffer.add("b");
    buffer.add("arrow_left");
    buffer.add("backspace");
    buffer.add("c");

    assertEquals("cb", buffer.toString());
  }

}