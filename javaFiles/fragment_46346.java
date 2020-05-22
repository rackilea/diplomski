StmtIterator stmtIterator = inf.listStatements(essaClasse, null, (RDFNode) null);
    while(stmtIterator.hasNext()) {
        Statement st = stmtIterator.next();
        Property p = st.getPredicate();
        RDFNode o = st.getObject();
        System.out.println(p + ":" + o);
    }