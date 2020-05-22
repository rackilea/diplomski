@Bean
public ReactiveWebServerFactory reactiveWebServerFactory() {
    NettyReactiveWebServerFactory factory = new NettyReactiveWebServerFactory();
    factory.addServerCustomizers(builder -> builder.loopResources(LoopResources.create("my-http", 16, true)));

    return factory;
}