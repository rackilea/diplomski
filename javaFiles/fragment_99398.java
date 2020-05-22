List<Parse> nounPhrases;

public void getNounPhrases(Parse p) {
    if (p.getType().equals("NP")) {
         nounPhrases.add(p);
    }
    for (Parse child : p.getChildren()) {
         getNounPhrases(child);
    }
}