StringBuilder sb = new StringBuilder(msglower);
for (Entry<String, String> replacement : replacements.entrySet()) {
  int start = sb.indexOf(replacement.geyKey(), 0);
  while (start >= 0) {
    int end = start + replacement.getKey().length();
    sb.replace(start, end, replacement.getValue());
    start = sb.indexOf(replacement.getKey(), start + replacement.getValue().length());
  }
}