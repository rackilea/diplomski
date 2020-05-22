static String readFile(String fileName) {
    StringBuilder sb = new StringBuilder();
    File file = new File(fileName);
    try (Scanner scanner = new Scanner(file);) {
        while (scanner.hasNext()) {
            String line = scanner.next();
            sb.append(line).append(System.lineSeparator());
        }
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
    return sb.toString();
}

static final String words = readFile("word_list.txt");

public static void print(String str, String str1, String str2)
        throws java.io.IOException {

    // output file name
    try (FileWriter output = new FileWriter("result.txt", true);
            PrintWriter write = new PrintWriter(new BufferedWriter(output))) {

        write.println("TEL: " + str);
        Scanner scanner = new Scanner(words);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (isMatch(str, line))
                write.printf("%s : %s %n", str, line);
        }
        scanner = new Scanner(words);
        while (scanner.hasNextLine()) {
            String line1 = scanner.nextLine();
            if (isMatch(str1, line1))
                write.printf("%s : %s %n", str1, line1);
        }
        scanner = new Scanner(words);
        while (scanner.hasNextLine()) {
            String line2 = scanner.nextLine();
            if (isMatch(str2, line2))
                write.printf("%s : %s %n", str2, line2);
        }

        write.println("--------");
    }
}