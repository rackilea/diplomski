List<Stores> storesList = mongoTemplate.find(new Query(), Stores.class);
    for(Stores stores : storesList) {
      System.out.println(stores.toString());
    }
    mongoTemplate.updateMulti(new Query(), new Update().pull("vegetables", "squash"), "stores");
    List<Stores> afterModificationStoresList = mongoTemplate.find(new Query(), Stores.class);
    for(Stores stores : afterModificationStoresList) {
      System.out.println(stores.toString());
    }