public static void main(String[] args) {
    System.out.println(Arrays.toString(new phoneNumberString().dial(223)));
}

public static String dialPad[][] = { { "0" }, { "1" }, { "A", "B", "C" }, { "D", "E", "F" }, { "G", "H", "I" },
        { "J", "K", "L" }, { "M", "N", "O" }, { "P", "Q", "R", "S" }, { "T", "U", "V" }, { "W", "X", "Y", "Z" } };

public String[] dial(int number) {
    int[] numberAsDigits = numberAsDigits(number);

    int[] counters = new int[numberAsDigits.length];
    boolean finished = false;
    List<String> results = new ArrayList<>();
    while (!finished) {
        // current combination
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < counters.length; i++) {
            String[] combosForCurrentDigit = dialPad[numberAsDigits[i]];
            builder.append(combosForCurrentDigit[counters[i]]);
        }
        results.add(builder.toString());

        // increment the counters
        counters[0]++;
        for (int i = 0; i < counters.length; i++) {
            String[] combosForCurrentDigit = dialPad[numberAsDigits[i]];
            if (counters[i] == combosForCurrentDigit.length) {
                counters[i] = 0;
                if (i + 1 == counters.length) {
                    finished = true;
                } else {
                    counters[i + 1]++;
                }
            }
        }
    }

    return results.toArray(new String[0]);
}

private int[] numberAsDigits(int number) {
    String numberAsString = String.valueOf(number);
    int[] numberAsDigits = new int[numberAsString.length()];
    char[] chars = numberAsString.toCharArray();
    for (int i = 0; i < chars.length; i++) {
        numberAsDigits[i] = Integer.parseInt(String.valueOf(chars[i]));
    }
    return numberAsDigits;
}