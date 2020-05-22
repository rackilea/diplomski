MongoCollection<Document> coll = db.getCollection("day_EURUSD");
    FindIterable<Document> fi = coll.find();
    fi.forEach(new Block<Document>() {
        @Override
        public void apply(final Document document) {
                    // Suppress the DB Id column of the query result.
               document.remove("_id");
        }
    });
    ...