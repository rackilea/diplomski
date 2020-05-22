public static List<Tree> getNounPhrasesWithMultipleKeywords(Annotation doc,
                                                              List<String> tags) {
    List<String> phrases = new ArrayList<String>();

    for (int i = 0; i < tags.size(); i++) {
      String word = tags.get(i);
      String[] splitted = word.split(" ");
      phrases.add(join(" . ", Arrays.asList(splitted)));
    }
    String pattern_str = join(" .. ", phrases);
    TregexPattern pattern = TregexPattern.compile(
      "NP << (" + pattern_str + ")");
    return getTreeWithPattern(doc, pattern);
  }

  // In Java 8 use String.join.
  public static String join(String sep, Collection<String> strs) {
    System.out.println(strs);
    StringBuilder sb = new StringBuilder();
    boolean first = true;
    for (String s : strs) {
      if (!first) {
        sb.append(sep);
      }
      sb.append(s);
      first = false;
    }
    return sb.toString();
  }