public int countOccurrences(String haystack, String needle) {
  int count = 0, offset = 0, index;
  // As long as there is another occurrence...
  while((index = haystack.indexOf(needle, offset)) != -1) {
    // Skip already matched parts the next time
    offset = index + needle.length();
    // Increment counter
    count++;
  }
  return count;
}