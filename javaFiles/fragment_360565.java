@Bean
public ResourceDatabasePopulator databasePopulator() {
    ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
    populator.setSqlScriptEncoding("UTF-8");
    populator.addScript(new ClassPathResource("setup_data.sql"));
    return populator;
}

@Bean
public InitializingBean populatorExecutor() {
    return new InitializingBean() {
        @Override
        public void afterPropertiesSet() throws Exception {
            DatabasePopulatorUtils.execute(databasePopulator(), dataSource());
        }
    };
}