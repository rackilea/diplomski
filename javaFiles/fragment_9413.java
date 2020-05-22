public static void main(String[] args) {
    String One = "f9 d4 62 aa f9 d4 62 aa 74 10 99 8b";
    String Two = "3c 9c a7 e2 3c 9c a7 e2 b1 58 f9 d4";

    int[] x = convert(One);
    int[] y = convert(Two);

    for (int i = 0; i < x.length; i++) {
        int number = x[i];
        int index = find(number, y);
        if (index > 0) {
            System.out.println("found (" + (i + 1) + "," + index + ")");
        }
    }

}

private static int find(int number, int[] array) {
    for (int i = 0; i < array.length; i++) {
        if (array[i] == number) {
            return i + 1;
        }
    }
    return 0;
}

private static int[] convert(String str) {

    String[] tokens = str.split("\\s");
    int[] result = new int[tokens.length / 2];

    for (int i = 0; i < tokens.length; i += 2) {
        String hex = tokens[i] + tokens[i + 1];
        result[i / 2] = Integer.parseInt(hex, 16);
    }

    return result;
}