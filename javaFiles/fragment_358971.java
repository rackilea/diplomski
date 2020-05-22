IntegrationFlow flow =  
   IntegrationFlows.from(Tcp.inboundAdapter(Tcp.netServer(2221)
                .serializer(TcpCodecs.crlf())
                .deserializer(TcpCodecs.lengthHeader1())
                .id("server")))
        .transform(Transformers.objectToString())
        .get();