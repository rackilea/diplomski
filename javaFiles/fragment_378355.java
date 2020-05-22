double one = 1.00;
String stringNumber;
if (one % 1 == 0) {
    Integer intOne = (int) one;
    stringNumber = intOne.toString();
} else {
    stringNumber = String.valueOf(one);
}