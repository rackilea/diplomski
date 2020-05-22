URL rimbaud = new URL("http://www.gutenberg.org/cache/epub/29302/pg29302.txt");
    int count = 0;
    try (BufferedReader in = new BufferedReader(new InputStreamReader(rimbaud.openStream()))) {
        int c;
        while ((c = in.read()) != -1) {
            if (!Character.isWhitespace(c)) {
                count++;
            }
        }
    }
    System.out.println(count);