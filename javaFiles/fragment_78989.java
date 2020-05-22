@Override
public void configure() throws Exception {
    from("timer:aTimer?fixedRate=true&period=10s")
            .setHeader(Exchange.HTTP_METHOD, constant("GET"))
            .to("ahc:https://restcountries.p.mashape.com/callingcode/90")
            .routeId("TEST")
            .log("${body}");
}