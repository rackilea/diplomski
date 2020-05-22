public int countOccurrences(String haystack, String needle) {
  int index = haystack.indexOf(needle);
  if(index == -1) return 0;
  int offset = index + needle.length();
  return 1 + countOccurrences(haystack.substring(offset), needle);
}