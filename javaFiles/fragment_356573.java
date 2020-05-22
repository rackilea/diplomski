public static void main(String[] args) {
    SpringApplicationBuilder parentBuilder =
            new SpringApplicationBuilder(ParentApplication.class)
                    .web(WebApplicationType.NONE);
    parentBuilder.run(args);
    parentBuilder.child(ServiceOneConfiguration.class)
            .properties("spring.config.name=child1").run(args);
    parentBuilder.child(ServiceTwoConfiguration.class)
            .properties("spring.config.name=child2").run(args);
}