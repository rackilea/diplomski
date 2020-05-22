int convert(String input) {
  if input is empty {
    return 0;
  }
  else {

    int lastDigit = last digit of input
    String prefix = input excluding last digit
    int result = convert(prefix) * 2 + lastDigit
  }

}