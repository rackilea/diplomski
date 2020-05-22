@Override
protected RouteBuilder createRouteBuilder() throws Exception {
return new RouteBuilder() {
    @Override
    public void configure() throws Exception {
        from("direct:start")
            // must enable preserveMessageQos to force Camel to use the JMSReplyTo header
            .to("activemq:queue:foo?preserveMessageQos=true")
            .to("mock:done");

        from("activemq:queue:foo")
            .to("log:foo?showAll=true", "mock:foo")
            .transform(body().prepend("Bye "));

        // we should disable reply to to avoid sending the message back to our self
        // after we have consumed it
        from("activemq:queue:bar?disableReplyTo=true")
            .to("log:bar?showAll=true", "mock:bar");
    }
};
}