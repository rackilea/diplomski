Properties props = new Properties();
props.load(IOUtils.readerFromString("StanfordCoreNLP-french.properties"));
StanfordCoreNLP corenlp = new StanfordCoreNLP(props);

Annotation ann = corenlp.process("Ceci est mon texte en français. Il contient plusieurs phrases.");
Document doc = new Document(props, ann);