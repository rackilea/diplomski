Client myClient = new Client(args);
Server myServer = new Server(args);

BlueClient = myClient.getBlueClient();
RedCLient = myClient.getRedClient();

BlueServer = myServer.getBlueServer();
RedServer = myServer.getRedServer();

myClient.addServer(blueServer);
myClient.addServer(redServer);

myServer.addClient(blueClient);
myServer.addClient(redClient);