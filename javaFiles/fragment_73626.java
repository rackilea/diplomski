public int indexOfFirstContainedCharacter(String s1, String s2) {
  Set<Character> set = new HashSet<Character>();
  for (int i=0; i<s2.length; i++) {
    set.add(s2.charAt(i)); // Build a constant-time lookup table.
  }
  for (int i=0; i<s1.length; i++) {
    if (set.contains(s1.charAt(i)) {
      return i; // Found a character in s1 also in s2.
    }
  }
  return -1; // No matches.
}