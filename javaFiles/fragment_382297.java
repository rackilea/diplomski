MongoClient client = new MongoClient(asList(new ServerAddress("localhost"), new ServerAddress("localhost:27018")),
                                         singletonList(MongoCredential.createCredential("username",
                                                                                        "admin",
                                                                                        "bad".toCharArray())),
                                         MongoClientOptions.builder().serverSelectionTimeout(1000).build());


    try {
        client.getDB("admin").command("ping");
    } catch (MongoTimeoutException e) {
        // do something
    }