@CheckReturnValue
@SchedulerSupport(SchedulerSupport.NONE)
public final Maybe<T> filter(Predicate<? super T> predicate) {
    ObjectHelper.requireNonNull(predicate, "predicate is null");
    return RxJavaPlugins.onAssembly(new MaybeFilterSingle<T>(this, predicate));
}