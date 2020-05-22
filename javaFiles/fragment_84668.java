@SpringBootApplication
public class So51200675Application {

    public static void main(String[] args) {
        SpringApplication.run(So51200675Application.class, args).close();
    }

    @Bean
    public ApplicationRunner runner() {
        return args -> {
            Socket socket = SocketFactory.getDefault().createSocket("localhost", 1234);
            socket.getOutputStream().write("{\"foo\":\"bar\"}\n".getBytes());
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println(reader.readLine());
            socket.close();
        };
    }

    @Bean
    public Map<String, String> fromToConnectionMappings() {
        return new ConcurrentHashMap<>();
    }

    @Bean
    public Map<String, String> toFromConnectionMappings() {
        return new ConcurrentHashMap<>();
    }

    @Bean
    public MapJsonSerializer serializer() {
        return new MapJsonSerializer();
    }

    @Bean
    public IntegrationFlow proxyRequestFlow() {
        return IntegrationFlows.from(Tcp.inboundAdapter(serverFactory()))
                .<Map<String, String>, Map<String, String>>transform(m -> {
                    m.put("foo", m.get("foo").toUpperCase());
                    return m;
                })
                .handle((p, h) -> {
                    mapConnectionIds(h);
                    return p;
                })
                .handle(Tcp.outboundAdapter(threadConnectionFactory()))
                .get();
    }

    @Bean
    public IntegrationFlow proxyReplyFlow() {
        return IntegrationFlows.from(Tcp.inboundAdapter(threadConnectionFactory()))
                .<Map<String, String>, Map<String, String>>transform(m -> {
                    m.put("foo", m.get("foo").toLowerCase() + m.get("foo"));
                    return m;
                })
                .enrichHeaders(e -> e
                        .headerExpression(IpHeaders.CONNECTION_ID, "@toFromConnectionMappings.get(headers['"
                                + IpHeaders.CONNECTION_ID + "'])").defaultOverwrite(true))
                .handle(Tcp.outboundAdapter(serverFactory()))
                .get();
    }

    private void mapConnectionIds(Map<String, Object> h) {
        try {
            TcpConnection connection = threadConnectionFactory().getConnection();
            String mapping = toFromConnectionMappings().get(connection.getConnectionId());
            String incomingCID = (String) h.get(IpHeaders.CONNECTION_ID);
            if (mapping == null || !(mapping.equals(incomingCID))) {
                System.out.println("Adding new mapping " + incomingCID + " to " + connection.getConnectionId());
                toFromConnectionMappings().put(connection.getConnectionId(), incomingCID);
                fromToConnectionMappings().put(incomingCID, connection.getConnectionId());
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Bean
    public ThreadAffinityClientConnectionFactory threadConnectionFactory() {
        return new ThreadAffinityClientConnectionFactory(clientFactory()) {

            @Override
            public boolean isSingleUse() {
                return false;
            }

        };
    }

    @Bean
    public AbstractServerConnectionFactory serverFactory() {
        return Tcp.netServer(1234)
                .serializer(serializer())
                .deserializer(serializer())
                .get();
    }

    @Bean
    public AbstractClientConnectionFactory clientFactory() {
        AbstractClientConnectionFactory clientFactory = Tcp.netClient("localhost", 1235)
                .serializer(serializer())
                .deserializer(serializer())
                .get();
        clientFactory.setSingleUse(true);
        return clientFactory;
    }

    @Bean
    public IntegrationFlow backEndEmulatorFlow() {
        return IntegrationFlows.from(Tcp.inboundGateway(Tcp.netServer(1235)
                    .serializer(serializer())
                    .deserializer(serializer())))
                .<Map<String, String>, Map<String, String>>transform(m -> {
                    m.put("foo", m.get("foo") + m.get("foo"));
                    return m;
                })
                .get();
    }

    @Bean
    public ApplicationListener<TcpConnectionCloseEvent> closer() {
        return e -> {
            if (fromToConnectionMappings().containsKey(e.getConnectionId())) {
                String key = fromToConnectionMappings().remove(e.getConnectionId());
                toFromConnectionMappings().remove(key);
                System.out.println("Removed mapping " + e.getConnectionId() + " to " + key);
                threadConnectionFactory().releaseConnection();
            }
        };
    }

}