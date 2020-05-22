@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
...
    @Bean
    public PlatformTransactionManager transactionManager() {
        return new ResourcelessTransactionManager();
    }
}