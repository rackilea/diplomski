.split(body(), new AggregationStrategy() {
    public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
        System.out.println("Aggregating");
        return oldExchange == null ? newExchange : oldExchange;
    }
})
    .process(new Processor() { // inside the split/aggregator EIP
        public void process(Exchange exchange) throws Exception {
            System.out.println("before throwing Exception");
            throw new Exception("my Exception");
        }
    })
.end(); // outside the split/aggregator EIP