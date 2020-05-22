Client newclient = new Client();
HashMap<Integer, Client> clients = new HashMap<>();

clients.put(newclient.getClientIdentifier(), newclient);

String requiredName = clients.get(scannedID).getClientName();