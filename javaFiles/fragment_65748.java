import java.util.Scanner;

public class Program1 {
    public static void main(String[] args) {
        int caseNumber, numberOfCases;
        String currentLine;
        int lineNumber;

        Scanner in = new Scanner(System.in);

        numberOfCases = Integer.parseInt(in.nextLine());
        String[] phoneNumbers = new String[numberOfCases];

        for (caseNumber = 0; caseNumber < numberOfCases; caseNumber++) {
            phoneNumbers[caseNumber] = in.nextLine();
        }

        for (lineNumber = 0; lineNumber < phoneNumbers.length; lineNumber++) {
            currentLine = phoneNumbers[lineNumber];
            currentLine = currentLine.replaceAll("-", "");

            if (currentLine.length() > 10) {
                currentLine = currentLine.substring(0, 10);
            }

            System.out.println(currentLine);

            StringBuffer printedLine = new StringBuffer(currentLine);
            printedLine.insert(3, '-');
            printedLine.insert(7, '-');

            System.out.println(printedLine);
        }
    }
}