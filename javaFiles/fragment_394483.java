public class YourOntology extends Ontology {
    public static final String NAME = "YourOntology";
    private static Ontology instance = new YourOntology();
    public static Ontology getInstance() {
        return instance;
    }

    private YourOntology() {
        super(NAME, BasicOntology.getInstance());

        add(new PredicateSchema("ParameterConcept"), ParameterConcept.class);
        PredicateSchema parameterConcept = (PredicateSchema) getSchema("ParameterConcept");
        parameterConcept.add("price",         (PrimitiveSchema) getSchema(BasicOntology.INTEGER), ObjectSchema.MANDATORY);
        parameterConcept.add("count",         (PrimitiveSchema) getSchema(BasicOntology.INTEGER), ObjectSchema.MANDATORY);
    }
}