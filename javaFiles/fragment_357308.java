public static void main(String[] args) {
    List<String> list = new ArrayList<String>(Arrays.asList(new String[] {
        "good", "better", "best", "best", "first", "last", "last", "last",
        "good"}));
    removeDuplicates(list);
    for (String x : list) {
      System.out.println(x);
    }
  }

  static void removeDuplicates(List<String> array) {
    for (int i = 0; i < array.size(); i++) {
      String next = array.get(i);

      // check if this has already appeared before
      for (int j = 0; j < i; j++) {
        // if it has, stop the search and remove it
        if (next.equals(array.get(j))) {
          array.remove(i);
          // decrement i since we just removed the i'th element
          i--;
          // stop the search
          break;
        }
      }
    }
  }