static void removeDuplicates(List<String> array) {
    Set<String> set = new HashSet<String>();

    for (int i = 0; i < array.size(); i++) {
      String next = array.get(i);

      // check if this has already appeared before
      if (!set.add(next)) {
        // if it has then remove it
        array.remove(i);
        // decrement i since we just removed the i'th element
        i--;
      }
    }
  }