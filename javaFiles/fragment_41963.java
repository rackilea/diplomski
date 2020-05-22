public static void main( String[] args ) {
    final OntModel ontModel = ModelFactory.createOntologyModel( OntModelSpec.RDFS_MEM );
    ontModel.setNsPrefix( "so", NS );
    final OntClass classA = ontModel.createClass( NS+"A" );
    final OntClass classB = ontModel.createClass( NS+"B" );
    final OntClass classC = ontModel.createClass( NS+"C" );

    final Individual x = ontModel.createIndividual( NS+"x", classA );
    x.addRDFType( classB );
    classC.createIndividual( NS+"x" );

    ontModel.write( System.out, "RDF/XML" );
}