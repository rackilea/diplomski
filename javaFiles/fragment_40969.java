public class HelperVerticle extends AbstractVerticle
{
    public static final String ADDRESS = "address_1";

    private Scheduler scheduler;

    @Override
    public void start() throws Exception
    {
        scheduler = Schedulers.fromExecutor(command -> context.runOnContext(v -> command.run()));
        vertx.eventBus().consumer(ADDRESS, this::consume);
    }

    private void consume(Message<Object> message)
    {
        Mono.delay(Duration.ofMillis(3000)) 
            .thenReturn("Content of Mono.") // this would come from external library
            .publishOn(scheduler)
            .subscribe(output ->
            {
                System.out.println("My verticle: " + Thread.currentThread().getName());
                message.reply(output + " " + message.body());
            }, error -> message.fail(1, error.getMessage()));
    }
}