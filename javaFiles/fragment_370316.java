public class LineNumber {
    public static void main(String[] args) {
        String text = "date : 08/12/2009" + "\n" + "value : 589.236" + "\n"
                + "smth : smth" + "\n" + "Fax : 25896217";

        System.out.println("'smth' first found at line: "
                + findFirstOccurenceLineNumber(text, "smth"));
    }

    private static int findFirstOccurenceLineNumber(String text, String needle) {
        String lines[] = text.split("\r|\n|\r\n|\n\r", -1);
        int lineNumber = 1;
        for (String line : lines) {
            if (line.contains(needle)) {
                return lineNumber;
            }
            lineNumber++;
        }
        return -1;
    }
}