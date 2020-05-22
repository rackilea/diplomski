int start = 0;
while (start < payload.length()) {
  int end = payload.indexOf('|', start);
  if (end == -1) {
    end = payload.length();
  }

  int equalsPos = payload.indexOf('=', start);
  if (equalsPos > end || equalsPos < 0) {
    // No = found between adjacent |s. Not valid format.
    return Collections.emptyMap();
  }

  // Extract the substrings between | and =, and = and the next |.
  map.put(payload.substring(start, equalsPos), payload.substring(equalsPos + 1, end));

  start = end + 1;
}