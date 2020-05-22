public static ArrayList<String> GetCollocations(String text) throws IOException,                ClassNotFoundException{
    MaxentTagger tagger = new MaxentTagger("taggers/wsj-0-18-left3words.tagger");
    String[] tagged = tagger.tagString(text).split("\\s+");
    ArrayList<String> collocations = new ArrayList();

    for (int i = 0; i < tagged.length; i++) {
        String pot = tagged[i].substring(tagged[i].indexOf("_") + 1);

        if (_isNoun(pot) || _isAdjective(pot)) {
            pot = tagged[i + 1].substring(tagged[i + 1].indexOf("_") + 1);

            if (_isNoun(pot) || _isAdjective(pot)) {
                collocations.add(GetWordWithoutTag(tagged[i]) + " " + GetWordWithoutTag(tagged[i + 1]));
                pot = tagged[i + 2].substring(tagged[i + 2].indexOf("_") + 1);

                if (_isNoun(pot)) {
                    collocations.add(GetWordWithoutTag(tagged[i]) + " " + GetWordWithoutTag(tagged[i + 1]) + " " + GetWordWithoutTag(tagged[i + 2]));
                }

            } else if (pot.equals("IN")) {
                pot = tagged[i + 2].substring(tagged[i + 2].indexOf("_") + 1);

                if (_isNoun(pot)) {
                    collocations.add(GetWordWithoutTag(tagged[i]) + " " + GetWordWithoutTag(tagged[i + 1]) + " " + GetWordWithoutTag(tagged[i + 2]));
                }

            }
        }
    }
    return collocations;

}