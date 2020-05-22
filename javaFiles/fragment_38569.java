active.forEach(new Consumer<CounterChain>() {
    CounterChain last;
    public void accept(CounterChain next) {
        if(last!=null) next.setStartCounter(last.getEndCounter());
        last = next;
    }
});