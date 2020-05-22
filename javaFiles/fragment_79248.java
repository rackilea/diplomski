public class Sentence {
    private List<String> nouns = new ArrayList<>;
    private List<String> verbs = new ArrayList<>;
    // TODO Adverbs, etc.
    public List<String> getNons() { return nouns; };
    // TODO Other getters, etc.
}

List<Sentence> sentenceList = new ArrayList<>();
for (String line: lines) {
   Sentence aux = new Sentence();
   PosToken=new StringTokenizer(SAPosTagging.tagedReview[line]);
   while(PosToken.hasMoreTokens()) {
       // TODO ...
       strToken=PosToken.nextToken();
       // TODO, lets assume it is a noun
       aux.getNouns().add(strToken);
       // TODO, etc.
   }
  sentenceList.add(aux);
}