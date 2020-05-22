private static void printRow(int n) {
    printNTimes(OuterChar, n);
    printNTimes(InnerChar, (Size - n) * 2);
    printNTimes(OuterChar, n);
    System.out.println();
}