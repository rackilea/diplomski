public static boolean isEven(int testNumber) {

  String strI = Integer.toString(testNumber);
  String lastCharacter = strI.substring(strI.length() - 1);
  return ("13579".indexOf(lastCharacter) == -1);

}