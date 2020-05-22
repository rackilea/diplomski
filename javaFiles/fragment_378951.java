@Bean
public App appBean() {
    return new App();
}
...
App app = (App) ctx1.getBean("appBean");