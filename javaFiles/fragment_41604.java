int number = 1234567890;
int len = Integer.toString(number).length();
int[] iarray = new int[len];
for (int index = 0; index < len; index++) {
    iarray[index] = number % 10;
    number /= 10;
}