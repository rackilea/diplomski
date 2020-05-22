for (Document document : myDocList) {
    Document doc = new Document(document);
    doc.setTrackName(newTrackName); // or doc.put("track", newTrackName); if your doc implements Map
    collection.insertOne(doc);
    System.out.println(document);
}