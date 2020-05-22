// complexity of O(N*M), where N is the length of the original string and M is the length of the substring
static String longestCommonSequence(String string, String sub) {
    List<Character> primaryMatch = new ArrayList<>();
    List<Character> secondaryMatch = new ArrayList<>();
    // N iterations loop on original string
    for(char c : string.toCharArray()) {
      // M iterations loop on the substring
      if(sub.indexOf(c) != -1) {
        primaryMatch.add(c);
      }
      else {
        if(!primaryMatch.isEmpty()) {
          // replace secondaryMatch content with the current longet match
          if(secondaryMatch.size() <= primaryMatch.size()) {
            secondaryMatch.clear();
            secondaryMatch.addAll(primaryMatch);
          }
          primaryMatch.clear();
        }
      }
    }
    if(primaryMatch.size() < secondaryMatch.size()) {
      return secondaryMatch.stream().map(String::valueOf).collect(Collectors.joining());
    }
    return primaryMatch.stream().map(String::valueOf).collect(Collectors.joining());
}