public MongoClient(List<ServerAddress> seeds,
               MongoClientOptions options)


//Creates a Mongo based on a list of replica set members or a list of mongos. It will find all members (the master will be used by default). If you pass in a single server in the list, the driver will still function as if it is a replica set. If you have a standalone server, use the Mongo(ServerAddress) constructor.

//If this is a list of mongos servers, it will pick the closest (lowest ping time) one to send all requests to, and automatically fail over to the next server if the closest is down. 

  MongoClient mongoClient = new MongoClient(Arrays.asList(
  new ServerAddress("10.4.0.121",6001),
  new ServerAddress("10.4.0.122",6001),
  new ServerAddress("10.4.0.123",6001)));