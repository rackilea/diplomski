public class AnnotationRemover extends JCasAnnotator_ImplBase {
    public static AnalysisEngineDescription getDescription() throws ResourceInitializationException {
        return AnalysisEngineFactory.createEngineDescription(AnnotationRemover.class);
    }

    public void initialize(UimaContext context) throws ResourceInitializationException {
        super.initialize(context);
    }

    public void process(JCas jCas) throws AnalysisEngineProcessException {
        List<TOP> tops = new ArrayList<TOP>(JCasUtil.selectAll(jCas));
        for (TOP t : tops) {
            if (!t.getType().getName().equals("mypackage.MyAnnotation")) 
                t.removeFromIndexes();
            }
        }
}