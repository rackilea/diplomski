ConcurrentMap<Integer, Socket> socketByClientIdMap = new ConcurrentHashMap<>();

// check if a client exists already,
if (socketByClientIdMap.containsKey(clientId))

//  add a socket by client id.
socketByClientIdMap.put(clientId, socket);

// get a socket for a client_id
Socket s = socketByClientIdMap.get(clientId);