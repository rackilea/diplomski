class Result<R> {
    List<R> values = new ArrayList<>();
    int exceptionCount = 0;
    // TODO getters
}

static <T, R> Result<R> mappingToListCountingExceptions(Function<T, R> mapper) {
    class Acc {
        Result<R> result = new Result<>();

        void add(T t) {
            try {
                R res = mapper.apply(t);
                result.value.add(res);
            } catch (Exception e) {
                result.exceptionCount++;
            }
        }

        Acc merge(Acc another) {
            result.values.addAll(another.values);
            result.exceptionCount += another.exceptionCount;
        }
    }
    return Collector.of(Acc::new, Acc::add, Acc::merge, acc -> acc.result);
}