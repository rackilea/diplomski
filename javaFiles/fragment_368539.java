import java.nio.charset.*;

class Test {
  public static void main(String[] args) {
    byte[] array = { -128 };
    byte[] convertedArray = new String(array, StandardCharsets.UTF_8).getBytes(StandardCharsets.UTF_8);
    for(int i=0; i<convertedArray.length; i++) {
      System.out.println(convertedArray[i]);
    }
  }
}