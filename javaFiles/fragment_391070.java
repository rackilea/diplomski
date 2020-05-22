public class Test {

    public static void main(String[] args) {

        String[] data = new String[] {
                "(X)",
                "(p a b)",
                "(func (func2 a) (func3 X Y))",
                "(equal eve (mother cain))",
                "((b X) Y)",
                "((((b W) X) Y) Z)"
        };


        for (String line:data) {
            int headIdx = 0;
            if (line.charAt(1) == '(') {
                headIdx = countBrackets(line);
            } else {
                String head = "";
                Scanner s = new Scanner(line);
                s.useDelimiter("[)|(| ]");
                head = s.next();
                headIdx = line.indexOf(head) + head.length() - 1;
            }
            System.out.println(headIdx);
        }

    }

    private static int countBrackets(String line) {
        int bracketCount = 0;
        int charCount = 0;
        for (int i = 1; i < line.length(); i++) {
            char c = line.charAt(i);
            if (c == '(') {
                bracketCount++;
            } else if (c == ')') {
                bracketCount--;
            }
            if (bracketCount == 0) {
                return charCount + 1;
            }
            charCount++;
        }
        throw new IllegalStateException("Brackets not nested properly");
    }
}