public static String search(String search, String target) {
        String result = "";
        search = search.toLowerCase();
        target = target.toLowerCase();
        StringBuilder temp = new StringBuilder();
        ArrayList<String> searchWords = new ArrayList<String>();
        ArrayList<String> targetWords = new ArrayList<String>();
        char lastChar = ' ';
        char currentChar = ' ';
        // search,text
        int swords, twords, sletters, tletters, mwords, mletters;
        swords = twords = sletters = tletters = mwords = mletters = 0;

        for (Character c : search.toCharArray()) {
        currentChar = c > 96 && c < 123 ? c : ' ';
        if (lastChar == ' ' && currentChar == ' ')
            continue;
        if (currentChar != ' ' && ++sletters != 0)
            temp.append(currentChar);
        else {
            searchWords.add(temp.toString());
            temp.setLength(0);
        }
        lastChar = currentChar;
        }
        searchWords.add(temp.toString());
        temp.setLength(0);
        lastChar = ' ';
        for (Character c : target.toCharArray()) {
        currentChar = c > 96 && c < 123 ? c : ' ';
        if (lastChar == ' ' && currentChar == ' ')
            continue;
        if (currentChar != ' ' && ++tletters != 0)
            temp.append(currentChar);
        else {
            targetWords.add(temp.toString());
            temp.setLength(0);
        }
        lastChar = currentChar;
        }
        targetWords.add(temp.toString());
        temp.setLength(0);
        search = searchWords.toString();
        target = targetWords.toString();
        swords = searchWords.size();
        twords = targetWords.size();
        int[] blm = new int[searchWords.size()]; // best letter match
        int lm = 0;// letter match
        for (int i = 0; i < searchWords.size(); i++) {
        for (String t : targetWords) {
            for (int i2 = 0; i2 < (searchWords.get(i).length() < t
                .length() ? searchWords.get(i).length() : t
                .length()); i2++) {
            if (t.charAt(i2) == searchWords.get(i).charAt(i2))
                lm++;
            }
            if (blm[i] < lm)
            blm[i] = lm;
            lm = 0;
        }
        }

        for (int i = 0; i < blm.length; i++) {
        if (blm[i] == searchWords.get(i).length())
            mwords++;
        mletters += blm[i];
        }

        result = MessageFormat
            .format("-----\nSearch text:\"{0}\"\nWords:{1}\nLetters:{2}\n-----\nTarget text:\"{3}\"\nWords:{4}\nLetters:{5}\n-----\nMatch Results\nWords:{6}/{1}\nLetters:{7}/{2}",
                search, swords, sletters, target, twords, tletters,
                mwords, mletters);
        return result;
    }