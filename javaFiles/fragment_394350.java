JacksonDBCollection<MyObject, String> coll = JacksonDBCollection.wrap(dbCollection, MyObject.class,
        String.class);
MyObject myObject = ...
WriteResult<MyObject, String> result = coll.insert(myObject);
String id = result.getSavedId();
MyObject savedObject = coll.findOneById(id);