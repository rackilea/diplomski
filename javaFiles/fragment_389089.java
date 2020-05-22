public class twoDimensionalCharacterArray {

    public static void main(String[] args) {

        int row = 6, col = 7;
        char[][] chars = new char[row][col];

        Scanner scan = new Scanner(System.in);
        System.out.print("Type in a sentence: ");
        String message = scan.nextLine();
        char[] messages = message.toCharArray();
        int i = 0;
        for (int r = 0; r < chars.length; r++) {
            for (int c = 0; c < col; c++) {
                if (i < messages.length) {
                    chars[r][c] = messages[i] == ' ' ? '*' : messages[i];
                    i++;
                } else {
                    chars[r][c] = '-';
                }
            }
        }
        for (char[] x : chars) {
            System.out.println(Arrays.toString(x));
        }
    }

}