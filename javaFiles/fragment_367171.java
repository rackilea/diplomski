String update = "INSERT DATA { .... }";
 Repository tempRep = new SailRepository(new MemoryStore());
 tempRep.init();
 try(RepositoryConnection conn = tempRep.getConnection()) {
     conn.prepareUpdate(update).execute());
     Model statements = QueryResults.asModel(conn.getStatements(null, null, null));
 }