public int compare(String s1, String s2) {
  int lengthComparison = s2.length() - s1.length();
  if (lengthComparison != 0) {
    return lengthComparison;
  }
  return s1.compareTo(s2);
}