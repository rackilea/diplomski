public class ByteArrayToAsciiChar {

  public String byteToCharacter(byte b) {
    return Character.valueOf((char)b).toString();
  }

  public static void main(String[] args) {
    byte[] byteArray = {
        0b00100101,
        0b01000001,
        0b01100001,
        0b01000010,
        0b01100010,
        0b01010101
    };

    ByteArrayToAsciiChar testClass = new ByteArrayToAsciiChar();

    for (byte b : byteArray) {
      System.out.println("Byte: " + b + " ==> " + testClass.byteToCharacter(b));
    }

  }

}