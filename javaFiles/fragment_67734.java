Map<String, List<String>> inMap =  new HashMap<>();
  List<Document> documents = new ArrayList<>();
  for(Map.Entry<String, List<String>> kv :inMap.entrySet()) {
     Document doc = new Document();
     doc.put("_id", kv.getKey());
     List<String> values = kv.getValue();
     doc.put("query", values.get(0));
            ... rest of values
     documents.add(doc);
  }
collection.insertMany(documents);