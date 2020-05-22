int largestNumber = 0;
int largestCount = 0;
for (int number = 2; number <= 1000000; number++) {
    long value = number;
    int count = 1;
    while (value != 1) {
        value = (value % 2 == 0 ? value / 2 : 3 * value + 1);
        count++;
    }
    if(count > largestCount) {
        largestNumber = number;
        largestCount = count;
    }
}
System.out.println(largestNumber);

System.out.println("Sequence (" + largestCount + "):");
long value = largestNumber;
for (int count = 2; value != 1; count++) {
    value = (value % 2 == 0 ? value / 2 : 3 * value + 1);
    System.out.println(count + ": " + value + (value != (int)value ? "  <====  " + (int)value : ""));
}