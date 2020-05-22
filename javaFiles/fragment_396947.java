Strings[] texts = {
    "Hello world.",
    "This is a test." };

// Create empty CAS/JCas initialized using uimaFIT typesystem auto-detection
JCas jcas = JCasFactory.createJCas();

// Instantiate some analysis engine
AnalysisEngine engine = AnalysisEngineFactory.createEngine(...);

// Process texts re-using the previously created CAS/JCas instance
for (String t : texts) {
    jcas.reset();
    jcas.setDocumentText(t);
    jcas.setDocumentLanguage("en");
    engine.process(jcas);
}

engine.collectionProcessComplete();
engine.destroy();