Properties props = new Properties();
props.setProperty("annotators", "tokenize,ssplit,parse");
StanfordCoreNLP pipeline = new StanfordCoreNLP(props);

Annotation ann = new Annotation("your sentence here");
for (int i = 0; i < 100; ++i) {
  new Thread() {
    @Override public void run() {
      pipeline.annotate(ann);  // except, you should probably annotate different documents.
      Tree tree = ann.get(SentencesAnnotation.class).get(0).get(TreeAnnotation.class);
    }
  }.start();
}