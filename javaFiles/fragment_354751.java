Public class IsGoodMessage implements Predicate {
    @Override
    public boolean matches(Exchange exchange) {
        Message message = exchange.getIn();
        Set unknownSet = message.getBody(Set.class);
        for (Object o : unknownSet) {
            if (o instanceof GoodMessage) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
}