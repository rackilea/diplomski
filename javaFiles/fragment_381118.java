from("restlet:http://localhost:8080/1/users/{id}/like/{beer}")
    .process(new Processor() {
        public void process(Exchange exchange) {
            // version 1 processing
        }
    );