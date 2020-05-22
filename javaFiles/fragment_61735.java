@SpringBootApplication
@EnableBinding(Sink.class)
public class Gitter55Application {

    public static void main(String[] args) {
        SpringApplication.run(Gitter55Application.class, args);
    }

    @Bean
    public ConsumerEndpointCustomizer<KafkaMessageDrivenChannelAdapter<?, ?>> customizer() {
        return (endpoint, dest, group) -> {
            endpoint.setOnPartitionsAssignedSeekCallback((assignments, callback) -> {
                assignments.keySet().forEach(tp -> callback.seekToBeginning(tp.topic(), tp.partition()));
            });
        };
    }

    @StreamListener(Sink.INPUT)
    public void listen(String value, @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) byte[] key) {
        System.out.println(new String(key) + ":" + value);
    }

    @Bean
    public ApplicationRunner runner(KafkaTemplate<byte[], byte[]> template,
            BindingsEndpoint bindings) {

        return args -> {
            while (true) {
                template.send("gitter55", "foo".getBytes(), "bar".getBytes());

                System.out.println("Hit enter to start");
                System.in.read();
                bindings.changeState("input", State.STARTED);
            }
        };

    }

}