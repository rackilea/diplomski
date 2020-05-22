.enrich("direct-vm:wiretap_exception", new AggregationStrategy() {
        @Override
        public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
            return oldExchange;
        }        
    })