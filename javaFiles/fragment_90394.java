from("direct:abc").to("http://domain.com").process(new Processor() {
    public void process(Exchange exchange) throws Exception {
        HttpServletRequest request = exchange.getIn().getBody(HttpServletRequest.class);
        // Log request parameters
    }
});