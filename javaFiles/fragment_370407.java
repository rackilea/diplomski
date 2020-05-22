private List<Order> getOrderForDates(List<Long> orderNumbers, String startDate, String endDate){
    return OrderUtil.runInBatches(orderNumbers, new Function<List<Long>, List<Order>>() {
        @Override
        public List<Order> apply(List<Long> orderBatch) {
            return orderDAO.getOrderForDates(orderBatch, startDate, endDate);
        }
    });
}