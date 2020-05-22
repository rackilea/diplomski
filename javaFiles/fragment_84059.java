@Bean
@DependsOn("liquibase")
public YourBean yourBean() {
    return new YourBean();
}

static class YourBean {

    @PostConstruct
    public void populateDatabase() {
        System.out.println("This will be called after Liquibase has finished");
    }

}