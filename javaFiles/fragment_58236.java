// the match state model
...xxxxxxabxxxxxaxxxxxabcdexxxx...
         ab     a     abcd

    File file = new File("path_to_your_file");
    String yourSearchWord = "abcd";
    int matchIndex = 0;
    boolean matchPrefix = false;
    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
        int chr;
        while ((chr = reader.read()) != -1) {
            if (matchPrefix == false) {
                char searchChar = yourSearchWord.charAt(0);
                if (chr == searchChar) {
                    matchPrefix = true;
                    matchIndex = 0;
                }
            } else {
                char searchChar = yourSearchWord.charAt(++matchIndex);
                if (chr == searchChar) {
                    if (matchIndex == yourSearchWord.length() - 1) {
                        // match!!
                        System.out.println("match: " + matchIndex);
                        matchPrefix = false;
                        matchIndex = 0;
                    }
                } else {
                    matchPrefix = false;
                    matchIndex = 0;
                }
            }
        }
    }