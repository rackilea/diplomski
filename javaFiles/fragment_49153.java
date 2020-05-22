MongoClient client = new MongoClient("localhost", 27017);
MongoDatabase database = client.getDatabase("test2");
MongoCollection<Document> collection = database.getCollection("collection1");

int count = 0;
int batch = 100;

List<InsertOneModel<Document>> docs = new ArrayList<>();

try (BufferedReader br = new BufferedReader(new FileReader("data/newclicklogs.json"))) {
      String line;
      while ((line = br.readLine()) != null) {
         docs.add(new InsertOneModel<>(Document.parse(line)));
         count++;
         if (count == batch) {
           collection.bulkWrite(docs, new BulkWriteOptions().ordered(false));
           docs.clear();
           count = 0;
        }
    }
}

if (count > 0) {
   collection.bulkWrite(docs, new BulkWriteOptions().ordered(false));
}