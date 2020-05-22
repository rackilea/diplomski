abstract class Server {
    abstract Connector retrieveConnector(Conf conf);
    void initializeConnector(Conf conf) {
        ...
        connector = retrieveConnector(conf);
    }
    ...
}

class ServerOne extends Server {
    public Connector retrieveConnector(Conf conf) {
         return conf.getServerOneConf().getConnector();
    }
}