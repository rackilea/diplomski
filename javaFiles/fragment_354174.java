Map<String, Object> parameters = new HashMap<String, Object>();
parameters.put("port", org.hornetq.core.remoting.impl.netty.TransportConstants
                      .DEFAULT_PORT);
parameters.put(TransportConstants.HOST_PROP_NAME, "127.0.0.1");

TransportConfiguration configuration = new TransportConfiguration(
        NettyConnectorFactory.class.getName(), parameters);