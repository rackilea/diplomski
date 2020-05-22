for(int i = 0; i < corpus2.size(); i++) {
    Document doc = corpus2.get(i);
    // remove corpus2's reference to loaded doc, but don't sync
    corpus2.unloadDocument(i, false);
    // "un-adopt" doc from old datastore
    doc.setDataStore(null);
    doc.setLRPersistenceId(null);
    // and save it into the new one
    luceneDataStore.adopt(doc);
    luceneDataStore.sync(doc);
    // add to the corpus
    corpus1.add(doc);
    // now we can unload properly
    corpus1.unloadDocument(doc);
    Factory.deleteResource(doc);
}
luceneDataStore.sync(corpus1);