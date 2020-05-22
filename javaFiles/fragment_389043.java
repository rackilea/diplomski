public void save(Collection<MyDomainObject> objects) {
     BulkWriteOperation bulkWriter = dbCollection.initializeUnorderedBulkOperation();
    for(MyDomainObject mdo : objects) {
        DBObject dbObject = convert(mdo);
        bulkWriter.find(new BasicDBObject("_id",new ObjectId(mdo.getId()))).upsert().replaceOne(dbObject);
     }
     bulkWriter.execute(writeConcern);
 }