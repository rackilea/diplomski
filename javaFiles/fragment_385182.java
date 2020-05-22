package my.package;

class EsperUtils {
  public static boolean contains(List<String> list1, List<String> list2) {

    // Check for list1 and list2 to contain same word
    for (String s1 : list1) {
      for (String s2 : list2) {
        if (s1.equals(s2)) return true;
      }
    }
    return false;
  }
}