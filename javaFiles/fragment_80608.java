xpath.setNamespaceContext(new NamespaceContext() {
    public String getNamespaceURI(String prefix) {
      switch (prefix) {
        case "rdf": return "http://www.w3.org/1999/02/22-rdf-syntax-ns#";
        case "rdfs" : return "http://www.w3.org/2000/01/rdf-schema#"; 
       }
    return prefix;

    }
    public String getPrefix(String namespace) {
        if (namespace.equals("rdf")) return "rdf";
        else if (namespace.equals("rdfs")) return "rdfs";
        else return null;
       }
    @Override
    public Iterator getPrefixes(String arg0) {
        // TODO Auto-generated method stub
        return null;
    }
    });