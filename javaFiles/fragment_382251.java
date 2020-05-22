Properties props = new Properties();
props.setProperty("annotators", "tokenize, ssplit, pos, lemma, ner, parse");
StanfordCoreNLP pipeline = new StanfordCoreNLP(props);

String sentence = "This is an example sentence.";
Annotation document = new Annotation(sentence);
pipeline.annotate(document);

List<CoreMap> sentences = document.get(SentencesAnnotation.class);
CoreMap map = sentences.get(0);
SemanticGraph semanticGraph = map.get(CollapsedCCProcessedDependenciesAnnotation.class);

for (IndexedWord vertex : new ArrayList<>(semanticGraph.vertexSet())) {
    String tag = vertex.tag();
    String ner = vertex.ner();
    int beginPosition = vertex.beginPosition();
}