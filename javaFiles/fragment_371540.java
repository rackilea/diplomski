private NettyOutbound out;
private Connection connection;

public ServerResponse connect() {
    return TcpClient.create()
        .host(tcpConfig.getHost())
        .port(tcpConfig.getPort())
        .handle(this::handleConnection)
        .connect()
        .flatMap(connection -> {
            this.connection = connection;
            log.info("Sending response to http client.");
            return ServerResponse.ok().build();
        });
}

private Publisher<Void> handleConnection(NettyInbound in, NettyOutbound out) {
    this.out = out;
    in.receive().asString(Charsets.ISO_8859_1)
        .log("In received")
        .subscribe(frameStr -> log.info(frameStr));
    return out
        .neverComplete()    //keep connection alive
        .log("Never close");
}

public void disconnect() {
    this.connection.dispose();
}