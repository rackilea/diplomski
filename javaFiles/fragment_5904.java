private static final String dbUrl = "remote:localhost/databaseName";
private static final String dbUser = "root";
private static final String dbPassword = "rootPassword";

public static void createDBIfDoesNotExist() throws IOException {

    OServerAdmin server = new OServerAdmin(dbUrl).connect(dbUser, dbPassword);
    if (!server.existsDatabase("plocal")) {
        server.createDatabase("graph", "plocal");
    }
    server.close();
}

public static void dropDBIfExists() throws IOException {

    OServerAdmin server = new OServerAdmin(dbUrl).connect(dbUser, dbPassword);
    if (server.existsDatabase("plocal")) {
        server.dropDatabase("plocal");
    }
    server.close();
}