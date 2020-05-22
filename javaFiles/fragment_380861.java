public int read_code_point (Reader input) throws java.io.IOException
{
  int ch16 = input.read();
  if (ch16 < 0 || !Character.isHighSurrogate((char)ch16))
    return ch16;
  else {
    int loSurr = input.read();
    if(loSurr < 0 || !Character.isLowSurrogate((char)loSurr)) 
      return ch16; // or possibly throw an exception
    else 
      return Character.toCodePoint((char)ch16, (char)loSurr);
  }
}