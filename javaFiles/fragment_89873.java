enum ConnectionType { UDP, TCP; }

class Connector {

    private static final ConnectionType DEFAULT_CONNECTION_TYPE = 
        ConnectionType.UDP;

    private final ConnectionType connectionType;

    public Connector(ConnectionType connectionType) {
        this.connectionType = connectionType;
    }

    public Connector() {
        this(DEFAULT_CONNECTION_TYPE);
    }
}