public void start() throws Exception {
        Runtime r = Runtime.getRuntime();
        Process p = r.exec(command);
        AsyncInputStream asyncInputStream = new AsyncInputStream(vertx, vertx.nettyEventLoopGroup(), p.getInputStream());
        asyncInputStream.handler(buffer ->
                lineHandler(buffer.getString(0, buffer.length() - 1))
        );
    }