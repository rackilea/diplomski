MongoClient mongoClient = new MongoClient();
        MongoDatabase db = mongoClient.getDatabase( "testX" );
        MongoCollection<BsonDocument> coll = db.getCollection("foo", BsonDocument.class);
        coll.drop();

        {
            BsonDocument doc = new BsonDocument();
            doc.put("from", new BsonInt32(23343223));
            doc.put("to", new BsonInt32(23343223));
            doc.put("msg", new BsonString("hello"));
            coll.insertOne(doc);

            doc.remove("_id");
            doc.put("from", new BsonInt32(8889));
            doc.put("to", new BsonInt32(99999));
            doc.put("msg", new BsonString("goodbye"));
            coll.insertOne(doc);
        }

        {
            BsonDocument query = new BsonDocument("from", new BsonInt32(8889));
            BsonDocument proj = new BsonDocument("msg", new BsonInt32(1));
            proj.put("_id",new BsonInt32(0));

            BsonDocument d2 = coll.find(query).projection(proj).first();
            System.out.println(d2);

            String s2 = coll.find(query).projection(proj).first().getString("msg").getValue();
            System.out.println(s2);
        }