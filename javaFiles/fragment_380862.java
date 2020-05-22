public int read_code_point (Reader input) throws java.io.IOException
{
  int firstChar = input.read();
  if (firstChar < 0 || !Character.isHighSurrogate((char)firstChar)) {
    return firstChar;
  } else {
    input.mark(1);
    int secondChar = input.read();
    if(secondChar < 0) {
      // reached EOF
      return firstChar;
    } else if(!Character.isLowSurrogate((char)secondChar)) {
      // unpaired surrogates, un-read the second char
      input.reset();
      return firstChar;
    }
    else {
      return Character.toCodePoint((char)firstChar, (char)secondChar);
    }
  }
}