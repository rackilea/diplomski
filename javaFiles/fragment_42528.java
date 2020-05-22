ServerAddress serverAddress = new ServerAddress(
                environmentHost, Integer.parseInt(environmentPort));

MongoCredential credential = MongoCredential.createCredential(
                environmentUserName,
                getDatabaseName(),
                environmentPassword.toCharArray());

MongoClient client =  new MongoClient(
                serverAddress, Arrays.asList(credential));