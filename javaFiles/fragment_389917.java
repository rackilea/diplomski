// set up pipeline
Properties props = new Properties();
props.setProperty("annotators", "tokenize");
StanfordCoreNLP tokenizerPipeline = new StanfordCoreNLP(props);

// get list of tokens for example sentence
String exampleSentence = "...";
// wrap sentence in an Annotation object
Annotation annotation = new Annotation(exampleSentence);
// tokenize sentence
tokenizerPipeline.annotate(annotation);
// get the list of tokens
List<CoreLabel> tokens = annotation.get(CoreAnnotations.TokensAnnotation.class);

//...
// classifier should be an AbstractSequenceClassifier

// get the k best sequences from your abstract sequence classifier
Counter<List<CoreLabel>> kBestSequences = classifier.classifyKBest(tokens,CoreAnnotations.NamedEntityTagAnnotation.class, 10)
// sort the k-best examples
List<List<CoreLabel>> sortedKBest = Counters.toSortedList(kBestSequences);
// example: getting the second best list
List<CoreLabel> secondBest = sortedKBest.get(1);
// example: print out the tags for the second best list
System.out.println(secondBest.stream().map(token->token.get(CoreAnnotations.NamedEntityTagAnnotation.class)).collect(Collectors.joining(" ")));
// example print out the score for the second best list
System.out.println(kBestSequences.getCount(secondBest));