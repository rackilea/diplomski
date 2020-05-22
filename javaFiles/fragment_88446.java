String folderPath = System.getProperty("user.dir");
        String fileSeparator = System.getProperty("file.separator");
        String path = folderPath + fileSeparator + "target" + fileSeparator + "httpconnector" + fileSeparator
                + "embeddedCassandra";
        URL url = HttpConnectorTest.class.getResource("/cassandra.yaml");
        System.setProperty("cassandra.config", url.toString());

    try {
        EmbeddedCassandraServerHelper.startEmbeddedCassandra("cassandra.yaml", path, 100000);