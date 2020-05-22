public static int sameCharsCount(String left, String right, boolean countDuplicates) {
    if ((null == left) || (null == right))
      return 0;

    HashMap<Character, Integer> occurence = new HashMap<Character, Integer>(); 

    for (int i = 0; i < left.length(); ++i) {
      Character ch = left.charAt(i);

      if (!occurence.containsKey(ch))
        occurence.put(ch, 1);
      else
        occurence.put(ch, occurence.get(ch) + 1);
    }

    int result = 0;

    for (int i = 0; i < right.length(); ++i) {
      Character ch = right.charAt(i);

      if (occurence.containsKey(ch)) {
        result += 1;

        if (!countDuplicates || occurence.get(ch) <= 1)
          occurence.remove(ch);
        else
          occurence.put(ch, occurence.get(ch) - 1);
      }
    }

    return result;
  }