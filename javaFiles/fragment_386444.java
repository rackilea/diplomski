String namespace = ".. your namespace here ..";
Resource bfo = m.getResource( namespace + "BFO:0000007" );
for (StmtIterator i = bfo.listProperties(); i.hasNext(); ) {
  Statement smt = i.next();
  System.out.println( "Resource " + stmt.getSubject().getURI() + 
                      " has property " + stmt.getPredicate().getURI() +
                      " with value " + stmt.getObject() );
}