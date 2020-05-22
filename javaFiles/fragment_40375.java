public class ObservableInteger {

    private Integer value;
    private PublishSubject<Integer> subject = PublishSubject.create();

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
        subject.onNext(value);
    }

    public Observable<Integer> getObservable() {
        return subject.asObservable();
    }
}