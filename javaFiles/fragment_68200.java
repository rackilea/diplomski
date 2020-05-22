//configure socket options
SocketOptions options = new SocketOptions();
options.setConnectTimeoutMillis(30000);
options.setReadTimeoutMillis(300000);
options.setTcpNoDelay(true);

//spin up a fresh connection (using the SocketOptions set up above)
cluster = Cluster.builder().addContactPoint(Configuration.getCassandraHost()).withPort(Configuration.getCassandraPort())
            .withCredentials(Configuration.getCassandraUser(), Configuration.getCassandraPass()).withSocketOptions(options).build();