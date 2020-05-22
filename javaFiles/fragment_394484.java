private static final Codec codec = new SLCodec();
private static final Ontology ontology = YourOntology.getInstance();

protected void setup() {
    getContentManager().registerLanguage(codec, FIPANames.ContentLanguage.FIPA_SL0);
    getContentManager().registerOntology(ontology);
}