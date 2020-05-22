for (Document document : myDocList) {
    collection.insertOne(new Document(document)).getObjectId(); //save this value
    //I don't know exactly which mongo driver do you use
    collection.updateOne(new Document("_id", savedObjId), new Document("$set", new Document("track", newTrackName)));
     System.out.println(document);
}