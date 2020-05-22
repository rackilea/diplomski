connectionString = new connectionString("mongodb://address1:27017,address2:27018,address3:27019/?replicaSet=rs0");
MongoClientSettings settings = MongoClientSettings.builder().applyConnectionString(connectionString)
                    .build();

settings = settings.builder().credential(credential).build();
asyncMongoClientInstance = MongoClients.create(settings);