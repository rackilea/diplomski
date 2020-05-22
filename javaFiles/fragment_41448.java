// Adds a document containing two fields: id and first_name, with
// values "123" and "randombee" respectively
SolrInputDocument document = new SolrInputDocument();
document.addField("id", "123");
document.addField("first_name", "randombee");
solr.add(document);
solr.commit(); // you MUST do this to commit the changes to your collection