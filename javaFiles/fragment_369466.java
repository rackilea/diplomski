@SpringBootApplication
public class So59117728Application {

    public static void main(String[] args) {
        SpringApplication.run(So59117728Application.class, args).close();
    }

    @Bean
    public ApplicationRunner runner(RedisConnectionFactory cf, IntegrationFlowContext context,
            RedisTemplate<String, String> template) {

        return args -> {
            IntegrationFlow flow = IntegrationFlows
                    .from(redisEndpoint("So59117728Application", cf))
                    .handle(System.out::println)
                    .get();
            context.registration(flow).id("myDynamicFlow").register();
            template.boundListOps("So59117728Application").leftPush("foo");

            Thread.sleep(10_000);
            context.remove("myDynamicFlow");
        };
    }

    private RedisQueueMessageDrivenEndpoint redisEndpoint(String queueName, RedisConnectionFactory cf) {
        RedisQueueMessageDrivenEndpoint endpoint = new RedisQueueMessageDrivenEndpoint(queueName, cf);
        endpoint.setSerializer(new StringRedisSerializer());
        return endpoint;
    }

}