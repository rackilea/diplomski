private static class MyAggregationStrategy implements AggregationStrategy {

    public Exchange aggregate(Exchange oldExchange, Exchange newExchange) 
    {
        if (oldExchange == null) 
        { 
           // the first time we only have the new exchange so it wins the first round
           return newExchange;
        }
        int oldPrice = oldExchange.getIn().getBody(Integer.class);
        int newPrice = newExchange.getIn().getBody(Integer.class);
        // return the "winner" that has the highest price
        return newPrice > oldPrice ? newExchange : oldExchange;
    }
}