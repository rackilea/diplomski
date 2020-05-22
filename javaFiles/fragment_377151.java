String mongo_url = System.getenv("MONGOHQ_URL");
    // If env var not set, try reading from Java "system properties"
    if (mongo_url == null) {
        mongo_url = System.getProperty("MONGOHQ_URL");
    }

    MongoURI mongoURI = new MongoURI(mongo_url);
    this.db = mongoURI.connectDB();

    // Only authenticate if username or password provided
    if (!"".equals(mongoURI.getUsername()) || mongoURI.getPassword().length > 0) {
        Boolean success = this.db.authenticate(mongoURI.getUsername(), mongoURI.getPassword());  

        if (!success) {
            System.out.println("MongoDB Authentication failed");
            return;
        }
    }
    this.my_collection = db.getCollection("my_collection");