@SpringBootApplication
public class So40471456Application {

    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext context = SpringApplication.run(So40471456Application.class, args);
        Socket socket = SocketFactory.getDefault().createSocket("localhost", 1234);
        socket.getOutputStream().write("foo\r\n".getBytes());
        try {
            System.out.println("\n\n\n" + socket.getInputStream().read() + "\n\n\n");
            context.getBean(EventListener.class).latch.await(10, TimeUnit.SECONDS);
        }
        finally {
            socket.close();
            context.close();
        }
    }

    @Bean
    public EventListener eventListener() {
        return new EventListener();
    }

    @Bean
    public TcpNetServerConnectionFactory server() {
        TcpNetServerConnectionFactory server = new TcpNetServerConnectionFactory(1234);
        server.setDeserializer(is -> {
            throw new SoftEndOfStreamException();
        });
        return server;
    }

    @Bean
    public TcpReceivingChannelAdapter inbound() {
        TcpReceivingChannelAdapter adapter = new TcpReceivingChannelAdapter();
        adapter.setConnectionFactory(server());
        adapter.setOutputChannelName("foo");
        return adapter;
    }

    public static class EventListener implements ApplicationListener<TcpConnectionCloseEvent> {

        private final Log logger = LogFactory.getLog(getClass());

        private final CountDownLatch latch = new CountDownLatch(1);

        @Override
        public void onApplicationEvent(TcpConnectionCloseEvent event) {
            logger.info(event);
            latch.countDown();
        }

    }

}