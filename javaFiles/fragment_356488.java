@SpringBootApplication
public class So40471456Application {

    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext context = SpringApplication.run(So40471456Application.class, args);
        Socket socket = SocketFactory.getDefault().createSocket("localhost", 1234);
        socket.getOutputStream().write("foo\r\n".getBytes());
        socket.close();
        Thread.sleep(10000);
        context.close();
    }

    @Bean
    public EventListener eventListener() {
        return new EventListener();
    }

    @Bean
    public TcpNetServerConnectionFactory server() {
        return new TcpNetServerConnectionFactory(1234);
    }

    @Bean
    public TcpReceivingChannelAdapter inbound() {
        TcpReceivingChannelAdapter adapter = new TcpReceivingChannelAdapter();
        adapter.setConnectionFactory(server());
        adapter.setOutputChannelName("foo");
        return adapter;
    }

    @ServiceActivator(inputChannel = "foo")
    public void syso(byte[] in) {
        System.out.println(new String(in));
    }

    public static class EventListener implements ApplicationListener<TcpConnectionCloseEvent> {

        private final Log logger = LogFactory.getLog(getClass());

        @Override
        public void onApplicationEvent(TcpConnectionCloseEvent event) {
            logger.info(event);
        }

    }

}