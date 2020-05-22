static class FindCompleteOrder extends DoFn<KV<String, Iterable<Order>>, Order> {
    String COMPLETE_EVENT_NAME = "COMPLETE";

    @ProcessElement
    public void processElement(ProcessContext c) {
        Iterator<Order> orders = c.element().getValue().iterator();
        boolean complete = false;

        do {
            try {
                Order order = orders.next();

                if (order.getEventName().equals(COMPLETE_EVENT_NAME)) {
                    complete = true;
                    order.setComplete(complete);
                    c.output(order);
                }
            } catch (Exception e) {
                LOG.error(e.getMessage());
            }
        } while (complete == false && orders.hasNext());
    }
}