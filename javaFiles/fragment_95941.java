private static class MyWindowFunction extends ProcessWindowFunction<IN, OUT, KEY, TimeWindow> {
    private final static ValueStateDescriptor<Long> myGlobalState =
      new ValueStateDescriptor<>("stuff", LongSerializer.INSTANCE);

    @Override
    public void process(KEY key, Context context, Iterable<IN> values,  Collector<OUT> out) {
        ValueState<Long> goodStuff = context.globalState().getState(myGlobalState);
    }
}