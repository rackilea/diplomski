public static void main(String[] args) {
  Byte[] a = new Byte[]{0x0};
  Byte[] b = a;
  Byte[] c = a;
  combine(a, b, c); 
}
public static <T> T[] combine(T[] ... a) {
  //do your magic here
}