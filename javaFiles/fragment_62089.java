public class PrintBinaryTest {

    public static void main(String[] args) {
        printBinaryNumbers(3);
    }

    public static void printBinaryNumbers(int digits) {
        int maxNr = (int) (Math.pow(2, digits) - 1);
        for (int i = 0; i <= maxNr; i++) {
            System.out.println(getBinaryRepresentationWithLeadingZeros(i, digits));
        }
    }

    public static String getBinaryRepresentationWithLeadingZeros(int nr, int digits) {
        String binaryString = Integer.toBinaryString(nr); // without leading zeros
        String formatString = "%" + digits + "s";
        return String.format(formatString, binaryString).replace(' ', '0');
    }
}