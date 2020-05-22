final HttpServer server = ServerBootstrap.bootstrap()
            .setListenerPort(9090)
            .setHttpProcessor(httpProcessor)
            .setSocketConfig(socketConfig)
            .setExceptionLogger(new StdErrorExceptionLogger ())
            .setHandlerMapper(handle_map)
            .create();