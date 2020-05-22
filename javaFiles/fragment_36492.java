private int sumCharValues (String input) {
  String str = input.toLowerCase(); // so 'A' and 'a' are equivalent
  int result = 0;
  for (int i = 0, n = str.length(); i < n; i++) {
    char c = str.charAt(i);
    result += (c - 'a' + 1);
  }
  return result;
}