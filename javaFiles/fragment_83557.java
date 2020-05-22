for (int i = 0; i < 20000; i++) {
        String utterance = grammar.getRandomSentence();
        String tags;
        try {
            tags = parser.getTagString(utterance);
            System.out.println(tags+" ==> "+utterance);

        } catch (GrammarException e) {
            error(e.toString());
        }
    }