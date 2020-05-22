DoubleBinding sumOfTotalsBinding = new DoubleBinding() {

    {
        bind(observableListOfTrades);
        observableListOfTrades.forEach(trade -> bind(trade.totalProperty());
        observableListOfTrades.addListener((Change<? extends Trade> change) -> {
            while (change.next()) {
                if (change.wasAdded()) {
                    change.getAddedSubList().forEach(trade -> bind(trade.totalProperty()));
                }
                if (change.wasRemoved()) {
                    change.getRemoved().forEach(trade -> unbind(trade.totalProperty()));
                }
            }
        });
    }

    @Override
    public double computeValue() {
        return observableListOfTrades.stream().collect(Collectors.summingDouble(Trade::getTotal));
    }
};