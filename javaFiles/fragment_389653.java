count = 0;
    try (Scanner sin = new Scanner(new BufferedReader(new InputStreamReader(rimbaud.openStream())))) {
        sin.useDelimiter("");
        char c;
        while (sin.hasNext()) {
            c = sin.next().charAt(0);
            if (!Character.isWhitespace(c)) {
                count++;
            }
        }
    }
    System.out.println(count);