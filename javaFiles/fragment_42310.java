String str = s.toString();
String[] splitString = str.split("'");
String firstItem = splitString[0];
try {
    int feet = Integer.parseUnsignedInt(firstItem);
    String secondPart = splitString[1].substring(0, splitString[1].length() - 1);
    int inches = Integer.parseUnsignedInt(secondPart);
    // YAY! you got your feet and inches!
    System.out.println(feet);
    System.out.println(inches);
} catch (NumberFormatException e) {
    return;
}