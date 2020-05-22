@Bean
CommandLineRunner runner(DSLContext create) {
    new CommandLineRunner() {
        @Override
        void run(String... args) throws Exception {
            create.selectOne().fetch()
        }
    }
}