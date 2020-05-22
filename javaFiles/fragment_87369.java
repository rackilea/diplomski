from("direct:StepA")
        .removeHeader("CamelHttpQuery")
        .removeHeader("CamelHttpRawQuery")
        .enrich("direct:StepAEnricher", new MyAggregator())
        .to("direct:StepB")
;

from("direct:StepAEnricher")
    .toD("netty4-http://myOtherService:8080/endpoint?input=${header.text}")
    .unmarshal().json(JsonLibrary.Jackson, MyResponse.class)
;