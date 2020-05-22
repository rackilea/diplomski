byte [] buffer = ...; // you know how to get this.
ByteArrayInputStream stream = new ByteArrayInputStream(buffer);

// if you have java.util.Scanner
{
    int lineNumber = 0;
    Scanner s = new Scanner(stream);

    while (s.hasNextLine()) {
        lineNum++;
        String line = s.nextLine();
        System.out.format("I am on line %s%n", lineNum);
        Scanner lineScanner = new Scanner(line);

        while (lineScanner.hasNext()) {
            String word = lineScanner.next();
            // do whatever with word
        }
    }
}

// if you don't have java.util.Scanner, or want to use StringTokenizer
{
    LineNumberReader reader = new LineNumberReader(
                          new InputStreamReader(stream));
    String line = null;

    while ((line = reader.nextLine()) != null) {
        System.out.println("I am on line " + reader.getLineNumber());
        StringTokenizer tok = new StringTokenizer(line);

        while (tok.hasMoreTokens()) {
            String word = tok.nextToken();
            // do whatever with word
        }
    }
}