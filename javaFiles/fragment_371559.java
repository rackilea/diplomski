@Configuration
class Example {
    @Bean
    public UncaughtExceptionHandler uncaughtExceptionHandler() {
        return (thread, throwable) -> System.out.println(thread + " => " + throwable.getMessage());
    }

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Thread newThread() {
        Thread thread = new Thread();
        thread.setUncaughtExceptionHandler(uncaughtExceptionHandler()); // <<<<<< allowing this
        return thread;
    }
}