DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
Entity e = new Entity("data");
e.setProperty("jsonString", "myValue");
Key key = ds.put(e);
Entity entity = ds.get(key);
System .out.println(entity);