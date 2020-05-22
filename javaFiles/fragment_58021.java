private final static int lineLength = 63;

public static void printSeparatorTitle(String heading) {

    System.out.println(createSeparator(lineLength));
    System.out.println(createSeparator(lineLength, heading));
    System.out.println(createSeparator(lineLength));
}

public static String createSeparator(int length) {

    final StringBuilder builder = new StringBuilder();
    while (length-- > 0) {
        builder.append("*");
    }
    return builder.toString();
}

public static String createSeparator(int length, String heading) {

    final int position = (length - heading.length() - 1) / 2;
    final StringBuilder builder = new StringBuilder();
    while (builder.length() < position) {
        builder.append("*");
    }

    builder.append(' ').append(heading).append(' ');

    while (builder.length() < length) {
        builder.append("*");
    }
    return builder.toString();
}

public static void main(String[] args) {

    printSeparatorTitle("Select Character");
    printSeparatorTitle("Select Stats");
    printSeparatorTitle("Select Display Method");

    // checking expected output:
    System.out.println("*********************** Select Character **********************"
            .equals(createSeparator(63, "Select Character")));

    System.out.println("************************* Select Stats ************************"
            .equals(createSeparator(63, "Select Stats")));

    System.out.println("******************** Select Display Method ********************"
            .equals(createSeparator(63, "Select Display Method")));
}