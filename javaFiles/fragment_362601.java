//Get the map containing the ID as keys, if it doesn't exist, then create one.
Map mapValuesForName = instancePairs.getOrDefault(inMemoryInstance.getUsername(), new ConcurrentHashMap<String,Set<PublicKey>>());

//Put the publicKeySet based on the Id.
mapValuesForName.putIfAbsent(inMemoryInstance.getId(), publicKeySet);

//Store the potentially changed/new value back in original map.
instancePairs.put(mapValuesForName);