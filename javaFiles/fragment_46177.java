//We can calculate the number of lines we need from the start
int lines = decimals / DIGITS_PER_LINE; //4, to start
lines += (decimals % DIGITS_PER_LINE > 0) ? 1 : 0; //5, add a line for remainders
System.out.print("3");
System.out.println(decimals > 0 ? "." : "");
for (int line = 0; line < lines; line++) {
    int offset = line * DIGITS_PER_LINE; //line -> result, 0 -> 0, 1 -> 10, 2 -> 20, etc
    int digitsLeft = decimals - offset; //0 -> 42, 1 -> 32, ... , 4 -> 2
    int toPrint = digitsLeft % DIGITS_PER_LINE; //up to the requested digit amount
    for (int i = 0; i < toPrint; i++) {
        System.out.print(pi.charAt(offset + i));
    }
    System.out.println();
}