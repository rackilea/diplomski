String binaryString = Integer.toString(num % 2);
while (num >= 2) {
    num = (int) num / 2;
    binaryString = Integer.toString(num % 2) + binaryString;
}
System.out.println(binaryString);