// the input file
java.net.URL url = new URL(“http://example.org/example.rdf”);

// guess the format of the input file (default to RDF/XML)
RDFFormat inputFormat = Rio.getParserFormatForFileName(url.toString()).orElse(RDFFormat.RDFXML);

// create a parser for the input file and a writer for Turtle format
RDFParser rdfParser = Rio.createParser(inputFormat);
RDFWriter rdfWriter = Rio.createWriter(RDFFormat.TURTLE,
               new FileOutputStream("/path/to/example-output.ttl"));

// link the parser to the writer
rdfParser.setRDFHandler(rdfWriter);

// start the conversion
try(InputStream inputStream = url.openStream()) {
   rdfParser.parse(inputStream, url.toString());
}
catch (IOException | RDFParseException | RDFHandlerException e) { ... }