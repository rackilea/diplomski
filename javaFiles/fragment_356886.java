public class run {
  public static void main(String argv[]) {
    System.loadLibrary("test");
    obj_t obj = new obj_t();
    short[] result = test.get_data(obj);
    for (int i = 0; i < result.length; ++i) {
      System.out.println(result[i]);
    }
  }
}