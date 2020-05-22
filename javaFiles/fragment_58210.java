public class Snippet {

  public static void main(String[] args) {
    int value = Integer.parseInt("1234567890");

    ByteBuffer b = ByteBuffer.allocate(4);
    b.putInt(value);
    byte[] result = b.array();

    System.out.println(result.length);  // 4
    System.out.println(Arrays.toString(result)); // [73, -106, 2, -46]
  }
}