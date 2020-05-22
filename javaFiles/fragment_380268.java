class ContainerCheck implements Observable.Operator<Container, Container> {
    @Override
    public Subscriber<? super Container> call(Subscriber<? super Container> o) {
        return new Subscriber<Container>() {
            @Override
            public void onCompleted() {
                if (o.isUnsubscribed()) return;
                o.onCompleted();
            }

            @Override
            public void onError(Throwable e) {
                if (o.isUnsubscribed()) return;
                o.onError(e);
            }

            @Override
            public void onNext(Container container) {
                if (o.isUnsubscribed()) return;
                if (container.success) {
                    o.onNext(container);
                } else {
                    o.onError(new Throwable("your costom exception"));
                }
            }
        };
    }
}