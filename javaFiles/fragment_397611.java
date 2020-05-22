public class TestCompare {
    public static void main() {
      List<String> list = Arrays.asList("10", "1", "20", "11", "21", "12");
      Comparator<String> cmp = new Comparator<String>() {
      public int compare(String o1, String o2) {
        return Integer.valueOf(o1).compareTo(Integer.valueOf(o2));
      }
      };
      Collections.sort(list, cmp);
    }
}