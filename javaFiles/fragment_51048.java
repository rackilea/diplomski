@Bean
public VelocityConfigurer velocityConfig() {
    VelocityConfigurer velocityConfigurer = new VelocityConfigurer();
    velocityConfigurer.setResourceLoaderPath("/WEB-INF/velocity/");
    return velocityConfigurer;
}