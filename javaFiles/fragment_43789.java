final String wkt = "http://www.opengis.net/ont/geosparql#wktLiteral";

// Stream result to stdout
final StreamRDF outputHandler = StreamRDFLib.writer(System.out);

StreamRDF inputHandler = new StreamRDFBase() {
    @Override
    public void triple(Triple triple) { // Got a triple
        Node object = triple.getObject();

        Node transformed;
        // if object is literal and has wkt type
        if (object.isLiteral() &&
                wkt.equals(object.getLiteralDatatypeURI())) {
            // Make a new node, suitably modified
            transformed = NodeFactory.createLiteral(
                    "<http://www.opengis.net/def/crs/EPSG/0/4326> " 
                            + object.getLiteralLexicalForm(), 
                    object.getLiteralDatatype());
        } else { // Do nothing
            transformed = object;
        }

        // Write out with corrected object
        outputHandler.triple(
                Triple.create( triple.getSubject(), triple.getPredicate(),
                        transformed
                        ));
    }
};

// Parse 
RDFDataMgr.parse(inputHandler, RDFDataMgr.open("file"));