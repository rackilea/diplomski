Map<String, Mapper<Users>> mappers = new ConcurrentHashMap<String, Mapper<Users>>();

Cluster cluster = ...;

Session firstClientSession = cluster.connect("keyspace_first_client");
Session secondClientSession = cluster.connect("keyspace_second_client");

MappingManager firstClientManager = new MappingManager(firstClientSession);
MappingManager secondClientManager = new MappingManager(secondClientSession);

mappers.put("first_client", firstClientManager.mapper(Users.class));
mappers.put("second_client", secondClientManager.mapper(Users.class));

// etc. for all clients