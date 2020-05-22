volatile boolean cancelled;

final Queue<T> queue;

final Subscriber<? super T> actual;

void drain() {
    Subscriber<? super T> a = actual;
    Queue<T> q = queue;

    for (;;) {
        if (cancelled) {
            return;
        }

        T v = q.poll();

        if (v == null) {
             a.onComplete();
             return;
        }

        a.onNext(v);
    }
}