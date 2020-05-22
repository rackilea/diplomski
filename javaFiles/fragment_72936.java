MongoClientOptions options = MongoClientOptions.builder()
            .readPreference(ReadPreference.nearest())
            .writeConcern(WriteConcern.W2)
            .build();
    MongoClient mongoClient = new MongoClient(Arrays.asList(
            new ServerAddress(serverList[0]),
            new ServerAddress(serverList[1]),
            new ServerAddress(serverList[2])),options);