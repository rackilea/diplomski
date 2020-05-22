private static String someFunction(String text, List<String> words) {
        //Container for the tagged strings
        List<String> tagged = new ArrayList<>();

        //Create comparator class for sorting list according to string length
        Comparator<String> x = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2)
            {
                if(s1.length() > s2.length())
                    return -1;

                if(s2.length() > s1.length())
                    return 1;

                return 0;
            }
        };

        //Sort list
        Collections.sort(words, x);

        //Replace all words in the text that matches a word in the word list
        //Note that we replace the matching word with a marker |0|, |1|, etc...
        for (int i = 0; i < words.size(); i++) {
            text = text.replaceAll(words.get(i), "\\|" + i + "\\|");
            //Save the matching word and put it between tags
            tagged.add("<tag>" + words.get(i) + "</tag>");
        }

        //Replace all markers with the tagged words
        for (int i = 0; i < tagged.size(); i++) {
            text = text.replaceAll("\\|" + i + "\\|", tagged.get(i));
        }


        return text;
    }