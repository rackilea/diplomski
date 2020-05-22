// in onBackpressureDrop
public void onNext(T value) {
    if (emitted != availablePermits) {
        emitted++;
        child.onNext(value);
    } else {
        // ignoring this value
    }
}