public String getRandomVerb() {
    String verb = "";

    if (!verbs.isEmpty()) {
        int num = (int) (Math.random() * verbs.size() - 1);
        verb = verbs.get(num);
    }

    return verb;
}

public String getRandomNoun() {
    String noun = "";

    if (!nouns.isEmpty()) {
        int num = (int) (Math.random() * nouns.size() - 1);
        noun = nouns.get(num);
    }

    return noun;
}

public String getRandomAdjective() {
    String adj = "";

    if (!adjectives.isEmpty()) {
        int num = (int) (Math.random() * adjectives.size());
        adj = adjectives.get(num);
    }

    return adj;
}