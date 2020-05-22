public static void main(String[] args) throws Exception {
    int lineCount = 0;// Variale used to count the numbers of line.
    File file = new File("file.txt");  //  file in same folder

    BufferedReader readFile = new BufferedReader(new FileReader(file));
    String lines;
    int[] count = new int[27];
    char ch;

    while ((lines = readFile.readLine()) != null) {
        System.out.println(lines);
        for (byte charByte : lines.getBytes()) {
            ch = (char) charByte;

            // Does this code count even uppercase or shall i convert
            // it the text to lower case.

            if (ch >= 'a' && ch <= 'z') {
                count[ch - 'a']++;
            // Count non-alpha characters here. Node: this will count numeric values also...
            } else if (ch < 'A' || ch > 'Z') {
                count[26]++;
            }
        }
        lineCount++;
    }

    System.out.println("file.txt containes " + lineCount + " lines.");

    for (int i = 0; i < 26; i++) {
        System.out.printf("%c: %d\n", i + 'A', count[i]);
    }
    System.out.printf("Special characters: %d\n", count[26]);
}