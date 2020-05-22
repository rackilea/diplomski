TextProcessor gen = new GeneralWordCounter(stopwords);

    while (s.hasNext()) {
        String word = s.next().toLowerCase();

        gen.process(word);

    }