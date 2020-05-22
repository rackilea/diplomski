public class FilterAndTake<T> implements Observable.Operator<T, T> {

    private OperatorFilter<T> filter;
    private OperatorTake<T> take;

    public FilterAndTake(Func1<? super T, Boolean> predicate, int n) {
        this.filter = new OperatorFilter<T>(predicate);
        this.take = new OperatorTake<T>(n);
    }

    @Override
    public Subscriber<? super T> call(final Subscriber<? super T> child) {
        return filter.call(take.call(child));
    }
}