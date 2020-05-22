.split(body()).stopOnException()
    .process(new Processor() { // inside the split/aggregator EIP
        public void process(Exchange exchange) throws Exception {
            System.out.println("before throwing Exception");
            throw new Exception("my Exception");
        }
    });