from("restlet:http://localhost:8080/{version}/users/{id}/like/{beer}")
    .process(new Processor() {
        public void process(Exchange exchange) {
            int version = exchange.getIn().getHeader("version", Integer.class);
            if (version == 1) {
                // version 1 processing
            } else {
                // version 2 processing
            }
        }
    );