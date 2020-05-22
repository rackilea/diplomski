public class MyBinder extends AbstractBinder {

@Override
protected void configure() {

    bindFactory(RoutingContextFactory.class)
        .to(RoutingContext.class)
        .proxy(true)
        .proxyForSameScope(false)
        .in(RequestScoped.class);

}

}