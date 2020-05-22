protected Mongo getMongo(String hostname, String port, String userName, String password, String databaseName)
throws UnknownHostException
{
     String authMech = "SCRAM-SHA-1";
     if ((this.version != null) && (this.version.contains("2."))) {
         authMech = "MONGODB-CR";
     }
     MongoClientURI uri = new MongoClientURI("mongodb://" + userName + ":" + password + "@" + hostname + ":" + port + "/?authSource=" + databaseName + "&authMechanism=" + authMech);
     MongoURI mongoUri = new MongoURI(uri);
     return new Mongo(mongoUri);
}