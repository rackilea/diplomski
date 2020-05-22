from("servlet://abc")  
    .process(new Processor(){
        @Override
        public void process(Exchange exchange) throws Exception {
            // Camel will populate all request.parameter and request.headers, 
            // no need for placeholders in the "from" endpoint
            String id = exchange.getIn().getHeader("id", String.class);
            String name = exchange.getIn().getHeader("name", String.class);           

            // This URI will override http://dummyhost
            exchange.getIn().setHeader(Exchange.HTTP_URI, "http://example.com");

            // Add input path. This will override the original input path.
            // If you need to keep the original input path, then add the id to the 
            // URI above instead
            exchange.getIn().setHeader(Exchange.HTTP_PATH, id);

            // Add query parameter such as "?name=xxx"
            exchange.getIn().setHeader(Exchange.HTTP_QUERY, "name="+name);     
    }
    .to("http://dummyhost")