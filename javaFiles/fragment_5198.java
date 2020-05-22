from("direct:getImg").process(new Processor() {
        @Override
        public void process(Exchange exchange) throws Exception {
            exchange.getIn().setHeader(Exchange.CONTENT_TYPE, MediaType.APPLICATION_XML);
        }
    }).to("restlet:http://requestb.in/12sowlx1?restletMethod=get&throwExceptionOnFailure=false");