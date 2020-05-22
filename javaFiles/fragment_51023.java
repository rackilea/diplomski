public static void main(String[] args) {
    // First we create the mda:
    String[][][] mda = new String[2][][];

    // Now we fill the mda[0][0][0] with 8
    mda[0] = new String[][] { {"8"} };

    // We make a deepCopy of mda[0] and put it in mda[1]:
    mda[1] = deepCopy(mda[0]);

    // Now we change the value of mda[1][0][0]:
    mda[1][0][0] = "42";

    // And here we show it is truly a copy, mda[0][0][0] isn't changed:
    System.out.println(mda[0][0][0]);
    System.out.println(mda[1][0][0]);
}

private static String[][] deepCopy(String[][] input) {
    String[][] output = new String[input.length][];
    for(int index = 0; index < input.length; index++) {
        output[index] = input[index].clone();
    }
    return output;
}