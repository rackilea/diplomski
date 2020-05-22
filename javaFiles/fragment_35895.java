public static void main(String[] args) {
    MongoClient mongo = new MongoClient("localhost", 27017);
    MongoDatabase db = mongo.getDatabase("myDatabase");

    List<Document> someDummyData = new ArrayList<>();
    for (int i = 0; i < 20; i++) {
        someDummyData.add(new Document("name", "Leslie" + i));
    }
    someDummyData.add(new Document("name", "John Wayne"));
    someDummyData.add(new Document("name", "Wayne"));
    someDummyData.add(new Document("name", "Acme"));
    someDummyData.add(new Document("name", "Leslie"));

    db.getCollection("names").insertMany(someDummyData);

    //we will have 24 names in our database
    System.out.println(db.getCollection("names").count());

    //obtain the search term ....
    String searchTerm = "Leslie";

    //an index is a good idea, if we want to use wildcard search... 1 means ascending order
    db.getCollection("names").createIndex(new Document("name", 1));

    //we will find exactly one element      -> this is exact match like in SQL: where name = searchTerm
    Iterable<Document> search1 =  db.getCollection("names").find(new Document("name", searchTerm));

    for(Document search : search1) {
        System.out.println("Exact match: " + search);
     }


    //we will find a few matches -> this is wildcard match like in SQL: where name LIKE %searchTerm$

    Iterable<Document> search2 = db.getCollection("names").find(regex("name", String.format(".*((?i)%s).*",
            searchTerm)));

    for (Document search : search2) {
        System.out.println("Wildcard match: " + search);
    }

    mongo.close();
}