public  void qexecute()
        {
        try{String query="db.products.insert( { item: "card", qty: 15 } )";
              MongoClient mongo = new MongoClient("localhost",27017);
              DB db = mongo.getDB("test");
              DBCollection collection = db.getCollection(tablename);  
              db.eval(query);   
             }
          catch(UnknownHostException e){
              System.out.println(e);
           }
           catch (MongoException.DuplicateKey e) {
              System.out.println("Exception Caught" + e);
           }
    }