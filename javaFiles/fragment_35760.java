from("direct:in")
    .process(new Processor() {
        public void process(Exchange exchange) {
            //These headers you set here will get sent with the http request in the to() after this processor
            exchange.getIn().setHeader("authUsername", "username");
            exchange.getIn().setHeader("authPassword", "password");
        }
    })
    .to("https4://uri.com);