Datastore datastore;
DatastoreOptions options = DatastoreOptions.newBuilder().setProjectId("yourprojectID").setCredentials(GoogleCredentials.fromStream( new FileInputStream("localKeyFile.json"))).build();
dataStore = options.getService();

List<Key> queryKeys = new ArrayList<>();
Key key = datastore.newKeyFactory().setKind("SomeKind").newKey(1234L);
queryKeys.add(key);

// Add more keys if you need to the List..then start query!

Iterable<Key> keyIterable = queryKeys;
List<Entity> entities = null;

// Get Results

entities = dataStore.fetch(keyIterable);