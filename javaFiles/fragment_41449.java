// Deletes document with id="mymockid"
solr.deleteById("mymockid");
solr.commit();

// Deletes all documents with first_name:randombee
solr.deleteByQuery("first_name:randombee");
solr.commit();