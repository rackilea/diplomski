int a = 0, and = 0, the = 0, forCount = 0;

while (sfile.hasNextLine()) {
    lines++;
    String line = sfile.nextLine();
    chars += line.length();
    StringTokenizer tokenizer = new StringTokenizer(line, " ,");
    words += tokenizer.countTokens();

    while (tokenizer.hasMoreTokens()) {
        String element = (String) tokenizer.nextElement();

        if ("a".equals(element)) {
            a++;
        } else if ("and".equals(element)) {
            and++;
        } else if ("for".equals(element)) {
            forCount++;
        } else if ("the".equals(element)) {
            the++;
        }
    }
}