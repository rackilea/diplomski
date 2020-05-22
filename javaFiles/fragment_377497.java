SetMultimap<String, B> idx = HashMultimap.create();
    for (B b : bList) {
        for (int i = 0; i < b.getFullURL().length() - NGRAM_LENGTH + 1; i++) {
            idx.put(b.getFullURL().substring(i, i + NGRAM_LENGTH), b);
        }
    }