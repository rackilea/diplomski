//Call next once in the iteration and reuse the doc:
while (iterator.hasNext()) {
   org.bson.Document nextDocument = iterator.next();
   coll_name.updateOne(eq("_id", nextDocument.get("_id")), new org.bson.Document("$set", new org.bson.Document("Name", getName((String) nextDocument.get("NameSource")))));
    System.out.println("Document _id " + nextDocument.get("_id") + " updated.....! in time : " + df.format(dater));
}