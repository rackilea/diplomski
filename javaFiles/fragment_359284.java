for (Server server : servers) {
    try {
        contactServer(server);
    }
    catch (MyCustomException e) {
        System.out.println("problem in contacting this server. Let's continue with the other ones");
    }
}