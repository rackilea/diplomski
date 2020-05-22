@Bean
public CommandLineRunner schedulingRunner(TaskExecutor executor) {
    return new CommandLineRunner() {
        public void run(String... args) throws Exception {
            executor.execute(new SimularProfesor());
        }
    }
}