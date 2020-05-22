public class diamond
{
    private static final char OuterChar = '*';
    private static final char InnerChar = ' ';
    private static final int Size = 10;

    public static void printNTimes(char value, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(value);
        }
    }

    private static void printRow(int n) {
        printNTimes(OuterChar, n);
        printNTimes(InnerChar, (Size - n) * 2);
        printNTimes(OuterChar, n);
        System.out.println();
    }

    public static void main(String[] args) {
        for (int c = Size; c >= 1; c--) {
            printRow(c);
        }
        for (int c = 2; c <= Size; c++) {
            printRow(c);
        }
    }
}