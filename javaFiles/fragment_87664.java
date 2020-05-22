public final class GatedSubject<T> {
    final PublishSubject<T> subject = PublishSubject.create();
    final AtomicReferenceArray<Boolean> gates;

    public GatedSubject(int numGates) {
        gates = new AtomicReferenceArray<>(numGates);
    }

    public boolean getGateStatus(int gateIndex) {
        return gates.get(gateIndex) != null;
    }

    public void setGateStatus(int gateIndex, boolean status) {
        gates.set(gateIndex, status ? Boolean.TRUE : null);
    }

    public void Observable<T> getGate(int gateIndex) {
        return subject.filter(v -> getGateStatus(gateIndex));
    }

    public void onNext(T item) {
        subject.onNext(item);
    }

    public void onError(Throwable error) {
        subject.onError(error);
    }

    public void onComplete() {
        subject.onComplete();
    }
}