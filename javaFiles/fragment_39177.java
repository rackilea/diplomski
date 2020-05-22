Document regx = new Document();
regx.append("$regex", "(?)" + Pattern.quote("colombo"));
regx.append("$options", "i");

Document query = new Document("names", regx).append("$age", new Document("$gt", 20));
FindIterable<Document> iterable = db.getCollection("coll").find(query);