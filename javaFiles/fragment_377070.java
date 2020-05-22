public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    char[] engArray = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
            'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
    String stringEngArray = String.valueOf(engArray);

    System.out.println("Text input");
    String inputedText = input.nextLine().toUpperCase();

    int inputedOffset = 4;

    char[] finalArray = inputedText.toCharArray();

    for (int i = 0; i < inputedText.length(); i++) {
        int engPosition = stringEngArray.indexOf(inputedText.charAt(i));
        int test = (i % inputedOffset);
        int newTest = engPosition + test;
        finalArray[i] = engArray[newTest];

    }
    String output = new String(finalArray);
    System.out.println(output);
}