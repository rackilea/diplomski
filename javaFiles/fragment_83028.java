List<ServerAddress> seeds = new ArrayList<ServerAddress>();
seeds.add( new ServerAddress( "localhost" );
List<MongoCredential> credentials = new ArrayList<MongoCredential>();
credentials.add(
    MongoCredential.createMongoCRCredential(
        "app_user",
        "data",
        "bestPo55word3v3r".toCharArray()
    )
);
MongoClient mongo = new MongoClient( seeds, credentials );