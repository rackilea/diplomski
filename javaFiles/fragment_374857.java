public static void print(String str, String str1, String str2)
        throws java.io.IOException {

    // output file name
    try (FileWriter output = new FileWriter("result.txt", true);
            PrintWriter write = new PrintWriter(new BufferedWriter(output))) {

        write.println("TEL: " + str);
        for (String line : words) {
            if (isMatch(str, line))
                write.printf("%s : %s %n", str, line);
        }
        for (String line : words) {
            if (isMatch(str1, line))
                write.printf("%s : %s %n", str1, line);
        }
        for (String line : words) {
            if (isMatch(str2, line))
                write.printf("%s : %s %n", str2, line);
        }

        write.println("--------");
    }
}