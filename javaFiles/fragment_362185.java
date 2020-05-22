public class AbcApplication {
    public static void main(String[] args) {
        HystrixPlugins.getInstance().registerCommandExecutionHook(new HystrixHook());
        SpringApplication.run(Abc.class, args);
    }
}