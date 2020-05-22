from("restlet:http://localhost:8080/2/users/{id}/like/{beer}")
    .process(new Processor() {
        public void process(Exchange exchange) {
            // version 2 processing
        }
    );