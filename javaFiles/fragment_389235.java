public static void main(String arg[]) {

            Gate.init();
            gate.Corpus corpus= (Corpus) Factory.createResource("gate.corpora.CorpusImpl");

//You need to register the plugin before you load it.

            Gate.getCreoleRegister().registerDirectories(new File(Gate.getPluginsHome(), ANNIEConstants.PLUGIN_DIR).toURI().toURL());
            Gate.getCreoleRegister().registerDirectories(new URL("file:///GATE_HOME/plugins/Tagger_Numbers"));//change this path


            Document doc = new DocumentImpl();
//The string to be annotated.

String str = "Height is 60 in. Weight is 150 lbs pulse rate 90 Pulse rate 90";
DocumentContentImpl impl = new DocumentContentImpl(str);
doc.setContent(impl);

//Loading processing resources. refer http://gate.ac.uk/gate/doc/plugins.html for what class the plugin belongs to

            ProcessingResource token = (ProcessingResource) Factory.createResource("gate.creole.tokeniser.DefaultTokeniser", Factory.newFeatureMap());
            ProcessingResource sspliter = (ProcessingResource) Factory.createResource("gate.creole.splitter.SentenceSplitter", Factory.newFeatureMap());
            ProcessingResource number = (ProcessingResource) Factory.createResource("gate.creole.numbers.NumbersTagger", Factory.newFeatureMap());


/*pipeline is an application that needs to be created to use resources loaded above.
Reasources must be added in a particular order eg. below the 'number' resource requires the document to be tokenised. */

corpus.add(doc);
SerialAnalyserController pipeline = (SerialAnalyserController) Factory.createResource("gate.creole.SerialAnalyserController", Factory.newFeatureMap(), Factory.newFeatureMap(), "ANNIE");
pipeline.setCorpus(corpus);
pipeline.add(token);
pipeline.add(sspliter);
pipeline.add(number);
pipeline.execute();

//Extract info from an annotated document.

AnnotationSetImpl ann=(AnnotationSetImpl)doc.getAnnotations();
Iterator<Annotation>i = ann.get(vital).iterator();
Annotation annotation = i.next();
long start = annotation.getStartNode().getOffset();
long end =  annotation.getEndNode().getOffset();
System.out.println(doc.toString().substring((int)start, (int)end));

}