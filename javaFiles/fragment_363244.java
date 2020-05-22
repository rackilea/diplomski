public static void main(String[] args) {

    String testS = "testkey";
    String key = "ABCDEFGHIJKLMNOPRSTUVWXYZ";

    testS = testS.toUpperCase() + key;
    testS = removeDuplicates(testS);
    System.out.println(testS);
}

static String removeDuplicates(String string) {

    StringBuilder noDuplicateChars = new StringBuilder();

    for (int i = 0; i < string.length(); i++) {

        String letter = string.substring(i, i + 1);

        if (noDuplicateChars.indexOf(letter) == -1) {
            noDuplicateChars.append(letter);
        }
    }

    return noDuplicateChars.toString();
}