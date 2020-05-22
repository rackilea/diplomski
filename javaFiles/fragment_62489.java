public static String replace(String s) {
StringBuilder myName = new StringBuilder(s);

for (int i = 1; i < s.length(); i++) {
  if (s.charAt(i) == 'r' && isVowel(s.charAt(i - 1))) {
    myName.setCharAt(i, 'h');

  }
}
return myName.toString();