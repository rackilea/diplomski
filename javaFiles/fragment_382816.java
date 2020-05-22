// parse the file into a Model object
  InputStream in = new FileInputStream(new File("/path/to/rdf-data.nt"));
  org.eclipse.rdf4j.model.Model model = Rio.parse(in, RDFFormat.NTRIPLES);

  for (org.eclipse.rdf4j.model.Statement st: model) {
       org.eclipse.rdf4j.model.Resource subject = st.getSubject();
       if (subject instanceof org.eclipse.rdf4j.model.IRI) {
              System.out.print(((IRI)subject).getLocalName());
       }
       else {
              System.out.print(subject.stringValue());
       }
       // ... etc for predicate and object (the 2nd and 3rd elements in each RDF statement)
  }