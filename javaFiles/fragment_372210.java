int currentPower = 1;
int length = string.length();
int value = 0;

for (int i = string.length()-1; i >= 0; --i) {
  char curChar = string.charAt(i);
  if (curChar >= '0' && curChar <= '9') {
    value += (curChar - '0') * currentPower;
    currentPower *= 10;
  }
  else
    currentPower = 1;
}