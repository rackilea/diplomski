StringBuilder digits = new StringBuilder();
StringBuilder nonDigits = new StringBuilder();
for (int i = 0; i < str.length(); ++i) {
  char ch = str.charAt(i);
  if (Character.isDigit(ch) {
    digits.append(ch);
  } else {
    nonDigits.append(ch);
  }
}
System.out.println(nonDigits);
System.out.println(digits);