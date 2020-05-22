public ClassA getClient(String aString, String bString) {
    ClientFactory clientFactory = new ClientFactoryImpl();
    return clientFactory.createNewClient(aString, bString);
}

public ClassB getConn(String cString, String dString) {
    ClientFactory clientFactory = new ClientFactoryImpl();
    return clientFactory.connect(cString, dString);
}