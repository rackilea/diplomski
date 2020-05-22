for (int i = 0; i < wordCharArr.length; i++) {
  String answer = word.substring(0, i) + word.substring(i + 1);
  if (list.lookup(answer)) {
    perm.add(answer);
  }
}