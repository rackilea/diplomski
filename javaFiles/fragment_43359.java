String string = "John gets a Star Wars ticket\n" +
            "Keith gets a soccer ticket\n" +
            "Mary gets a Star Wars ticket";
    for (String line : string.split("\n")) {
        if (line.matches(".*Star Wars.*")) {
            System.out.println(line);
        }
    }