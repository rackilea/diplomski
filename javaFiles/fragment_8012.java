String input = "This is a \"long\" statement.SortedSet Collections.";

    //split string based on your delimiters ( space, comma, dot )
    String[] split = input.split("[ ,.]");
    List<String> splitData = Arrays.asList(split);

    //create the data map with num occurances
    Map<String, Integer> dataToNumOccurances = new HashMap<>();
    for (String aString : splitData) {
        int occurrences = Collections.frequency(splitData, aString);
        dataToNumOccurances.put(aString, occurrences);
    }

    //convert to list so that it could be custom sorted
    List<String> sortedWords = new ArrayList<>(dataToNumOccurances.keySet());
    sortedWords.sort(new Comparator<String>()
    {
        @Override
        public int compare(String m1, String m2)
        {
            //apply the rule to push back double quoted string
            if (m1.startsWith("\"")) {
                return m2.compareToIgnoreCase(m1);
            }
            //apply case in-sensitive sort
            return m1.compareToIgnoreCase(m2);
        }
    });


    for (String word : sortedWords) {
        System.out.println("Word: " + word + ", count: " + dataToNumOccurances.get(word));
    }