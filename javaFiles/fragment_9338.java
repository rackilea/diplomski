d = new Document();
    d.add(new LongField("id", 4, Field.Store.YES));
    iw.addDocument(d);

    d = new Document();
    d.add(new LongField("id", 2, Field.Store.YES));
    iw.addDocument(d);