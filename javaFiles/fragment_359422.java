public final class OperatorRequestBatcher<T> 
implements Operator<List<T>, T> {
    final Scheduler scheduler;
    public OperatorRequestBatcher(Scheduler scheduler) {
        this.scheduler = scheduler;
    }
    @Override
    public Subscriber<? super T> call(Subscriber<? super List<T>> t) {
        Scheduler.Worker w = scheduler.createWorker();
        RequestBatcherSubscriber<T> parent = 
                new RequestBatcherSubscriber<>(t, w);

        t.add(w);
        t.add(parent);

        return parent;
    }

    static final class RequestBatcherSubscriber<T> 
    extends Subscriber<T> implements Action0 {
        final Subscriber<? super List<T>> actual;
        final Scheduler.Worker w;
        final Queue<T> queue;
        final AtomicInteger wip;

        volatile boolean done;
        Throwable error;

        public RequestBatcherSubscriber(
                Subscriber<? super List<T>> actual, 
                Scheduler.Worker w) {
            this.actual = actual;
            this.w = w;
            this.wip = new AtomicInteger();
            this.queue = new SpscLinkedArrayQueue<>(256);
        }

        @Override
        public void onNext(T t) {
            if (done) {
                return;
            }
            queue.offer(t);
            schedule();
        }

        @Override
        public void onError(Throwable e) {
            if (done) {
                return;
            }
            error = e;
            done = true;
            schedule();
        }

        @Override
        public void onCompleted() {
            done = true;
            schedule();
        }

        void schedule() {
            if (wip.getAndIncrement() == 0) {
                w.schedule(this);
            }
        }

        @Override
        public void call() {
            int missed = 1;

            final Queue<T> q = queue;
            final Subscriber<? super List<T>> a = actual;
            final AtomicInteger wip = this.wip;

            for (;;) {

                List<T> list = new ArrayList<>();

                for (;;) {
                    boolean d = done;
                    T v = q.poll();
                    boolean e = v == null;

                    if (isUnsubscribed()) {
                        q.clear();
                        return;
                    }

                    if (d) {
                        Throwable err = error;
                        if (err != null) {
                            a.onError(err);
                            return;
                        } else
                        if (e) {
                            if (!list.isEmpty()) {
                                a.onNext(list);
                            }
                            a.onCompleted();
                            return;
                        }
                    }

                    if (e) {
                        break;
                    }

                    list.add(v);
                }

                if (!list.isEmpty()) {
                    a.onNext(list);
                }

                missed = wip.addAndGet(-missed);
                if (missed == 0) {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        PublishSubject<Integer> ps = PublishSubject.create();
        TestScheduler sch = Schedulers.test();

        ps.lift(new OperatorRequestBatcher<>(sch))
        .subscribe(System.out::println, Throwable::printStackTrace, 
                () -> System.out.println("Done"));

        ps.onNext(1);
        ps.onNext(2);

        sch.advanceTimeBy(1, TimeUnit.MILLISECONDS);

        ps.onNext(3);

        sch.advanceTimeBy(1, TimeUnit.MILLISECONDS);

        ps.onNext(4);
        ps.onNext(5);
        ps.onNext(6);
        ps.onCompleted();

        sch.advanceTimeBy(1, TimeUnit.MILLISECONDS);
    }
}