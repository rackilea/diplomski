final class DoCountOperator<T> implements Observable.Operator<T,T> {

    interface CountObserver {
        void onNext(int emissionCount);
        void onError(int emissionCount);
        void onCompleted(int emissionCount);
    }

    private final DoCountOperator.CountObserver doObserver;

    DoCountOperator(DoCountOperator.CountObserver doObserver) {
        this.doObserver = doObserver;
    }

    @Override
    public Subscriber<? super T> call(Subscriber<? super T> child) {
        Subscriber<T> parent = new Subscriber<T>() {
            private int count = 0;
            private boolean done = false;

            @Override
            public void onCompleted() {
                if (done) {
                    return;
                }
                try {
                    doObserver.onCompleted(count);
                }catch (Throwable throwable) {
                    //Exceptions.throwIfFatal(throwable);
                    onError(throwable);
                }

                done = true;
                child.onCompleted();
            }

            @Override
            public void onError(Throwable throwable) {
                if (done) {
                    return;
                }
                try {
                    doObserver.onError(count);
                } catch (Throwable throwable1) {
                    throwable1.printStackTrace();
                }
                child.onError(throwable);
            }

            @Override
            public void onNext(T t) {
                if (done) {
                    return;
                }
                try {
                    doObserver.onNext(++count);
                }catch (Throwable throwable) {
                    Exceptions.throwIfFatal(throwable);
                }
                child.onNext(t);
            }

            @Override
            public void setProducer(Producer p) {
                child.setProducer(p);
            }
        };

        child.add(parent);

        return parent;
    }
}