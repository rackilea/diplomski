@Configuration
class SpringConfiguration {

    @Bean(name="variable")
    public String geVariable() {
        return System.getenv("whatever");
    }

    @Bean
    @DependsOn("variable")
    public MyService getMyService() {
        return new MyService(geVariable());
    }

    @Bean
    @DependsOn("variable")
    public MyService2 getMyService2() {
        return new MyService2(geVariable());
    }
}