List<String> lookUp = new ArrayList<>();
    lookUp.add("New York");
    lookUp.add("New Jersey");
    lookUp.add("Big Apple");
    lookUp.add("George W. Bush");

    String sentence = "New York is also called Big Apple . New Jersey is located near to New York . George W. Bush doesn't live in New Mexico`";

    String currentPhrase = "";
    List<String> parseResult = new ArrayList<>();

    for (String word : sentence.split("\\s+")) {
        currentPhrase += (currentPhrase.isEmpty() ? "" : " ") + word;
        if (lookUp.contains(currentPhrase)) {
            parseResult.add(currentPhrase);
            currentPhrase = "";
            continue;
        }
        boolean phraseFound = false;
        for (String look : lookUp)
            if (look.startsWith(currentPhrase)) {
                phraseFound = true;
                break;
            }

        if (!phraseFound) {
            parseResult.addAll(Arrays.asList(currentPhrase.split("\\s+")));
            currentPhrase = "";
        } 
    }

    System.out.println(parseResult);