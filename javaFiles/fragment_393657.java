String numbers = "123";
char[] numArray = numbers.toCharArray();

for (char c : numArray) {
    int num = Character.getNumericValue(c);
    // Do what you will with the number.
}