boolean foundDigit = false;
boolean foundLetter = false;
for (int i = 0; i < str.length(); ++i) {
  if (Character.isDigit(c)) { foundDigit = true; }
  else if (Character.isLetter(c)) { foundLetter = true; }
}
return str.length() >= 8 && foundDigit && foundLetter;