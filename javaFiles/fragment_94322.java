public class TriangleDriver {
    private static final String REQUEST = "Please enter value of N: ";
    private static final String SPACER3 = "   ";
    private static final String SPACER4 = "    ";
    private static final String DIVIDER = "----";
    private static final String FORMAT_ONE = "  %d    ";
    private static final String FORMAT_FIRST_ROW = "%7.0f";
    private static final String FORMAT_ADDITIONAL_ROWS = "%7.2f";
    private static final int HEADER_LINES = 2;

    public static void main(String[] args) {
        int num = getIntInput(REQUEST);
        StringBuilder[] result = solution(num);
        printSBArray(result);
    }

    static private int getIntInput(String request){
        System.out.print(request);
        return new Scanner(System.in).nextInt();
    }

    static private void printSBArray(StringBuilder[] sbArray){
        for (StringBuilder sb : sbArray)
            System.out.println(sb.toString());
    }

    static private StringBuilder[] solution(int num){
        StringBuilder output[] = new StringBuilder[num + HEADER_LINES];
        for(int i = 0; i < output.length; i++)
            output[i] = new StringBuilder("");

        // build line 0
        output[0].append(SPACER4 + SPACER4);
        for (int i = 1; i <= num; i++) {
            output[0].append(String.format(FORMAT_ONE, i));
        }

        // build line 1
        output[1].append(DIVIDER + SPACER4);
        for (int i = 0; i < num; i++)
            output[1].append(String.format(DIVIDER + SPACER3));

        // build line 2
        int i = 0;
        output[2].append((i + 1) + SPACER4);
        for (int j = 1; j <= num; j++) {
            output[2].append(String.format(FORMAT_FIRST_ROW, Math.sqrt(i * i + j * j)));
        }

        // build line 3+
        for (i = 1; i < num; i++) {
            output[i + 2].append((i + 1) + SPACER4);
            for (int j = 1; j <= num; j++) {
                output[i + 2].append(String.format(FORMAT_ADDITIONAL_ROWS, Math.sqrt(i * i + j * j)));
            }
        }
        return output;
    }
}