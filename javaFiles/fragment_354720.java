XmppManager.config = XMPPTCPConnectionConfiguration.builder()
            .setServiceName(serverName)
            .setHost(server)
            .setPort(port)
            .build();

    connection = new XMPPTCPConnection(config);

ConnectionListener connectionListener = new ConnectionListener(){...}; //
connection.addConnectionListener( connectionListener );

int RECONNECTION_ATTEMPT_SECONDS  = 60;

ReconnectionManager.getInstanceFor(connection).enableAutomaticReconnection();
ReconnectionManager.getInstanceFor(connection).setFixedDelay( RECONNECTION_ATTEMPT_SECONDS );