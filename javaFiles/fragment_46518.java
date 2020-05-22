char[] forwardChars = new char[str.length()];
char[] reverseChars = new char[str.length()];
for (int i = 0; i < str.length(); i++) {
    forwardChars[i] = str.charAt(i);
    reverseChars[reverseChars.length - i - 1] = str.charAt(i);
}
String forwardString = new String(forwardChars);
String reverseString = new String(reverseChars);