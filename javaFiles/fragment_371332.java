private void accumulateFrags(List<String> strings, int start, String prefix, List<String> frags) {
  if (start == strings.size()) {
    frags.add(prefix);
    return;
  }
  String current = strings.get(start);
  for (char c : current.toCharArray()) {
    accumulateFrags(strings, start + 1, prefix + c, frags);
  }
}