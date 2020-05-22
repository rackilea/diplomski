public static void getImage() throws FileNotFoundException {
    String string = "";
    try(Scanner input = new Scanner(new File(fileName)))
    {
        input.nextLine(); // skip width/height
        for (int n = 0; n < (imageHeight);) {

            string = input.nextLine();
            char[] charArray = string.toCharArray();

            for (int p = 0; p < (charArray.length); p++) {

                char a = charArray[p];
                buffer[n][p] = (a);

            }
            n = n + 1;
        }
    }
}