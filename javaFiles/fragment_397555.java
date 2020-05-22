public static void main(String[] args) {
    String key = "Jake";

    // Build string
    String str = "";
    char ch = 'a';
    for (int c = 0; c < 25; c++) {
        str += ch;
        ch++;
        if (ch == 'i') {
            ch++;
        }
    }
    System.out.println(str);

    // Remove chars from key
    String modifiedKey = key.toLowerCase().replace('i', 'j');
    for (int i = 0; i < key.length(); i++) {
        str = str.replaceAll("" + modifiedKey.charAt(i), "");
    }
    System.out.println(str);

    // Add key in the beginning
    str = key.toLowerCase() + str;
    System.out.println(str);

    // Print out
    for (int row = 0; row < 5; row++) {
        for (int col = 0; col < 5; col++) {
            System.out.print(str.charAt(row * 5 + col));
        }
        System.out.println();
    }
}