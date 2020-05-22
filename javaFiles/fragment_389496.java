import java.util.concurrent.TimeUnit;

import rx.*;
import rx.Observable.Operator;
import rx.schedulers.Schedulers;

public class SpanOut<T> implements Operator<T, T> {
    final long time;

    final TimeUnit unit;

    final Scheduler scheduler;

    public SpanOut(long time, TimeUnit unit, Scheduler scheduler) {
        this.time = time;
        this.unit = unit;
        this.scheduler = scheduler;
    }

    @Override
    public Subscriber<? super T> call(Subscriber<? super T> t) {
        Scheduler.Worker w = scheduler.createWorker();

        SpanSubscriber<T> parent = new SpanSubscriber<>(t, unit.toMillis(time), w);

        t.add(w);
        t.add(parent);

        return parent;
    }

    static final class SpanSubscriber<T> extends Subscriber<T> {
        final Subscriber<? super T> actual;

        final long spanMillis;

        final Scheduler.Worker worker;

        long lastTime;

        public SpanSubscriber(Subscriber<? super T> actual, 
                long spanMillis, Scheduler.Worker worker) {
            this.actual = actual;
            this.spanMillis = spanMillis;
            this.worker = worker;
        }

        @Override
        public void onNext(T t) {
            long now = worker.now();
            if (now >= lastTime + spanMillis) {
                lastTime = now + spanMillis;
                worker.schedule(() -> {
                    actual.onNext(t);
                });
            } else {
                long next = lastTime - now;
                lastTime += spanMillis;
                worker.schedule(() -> {
                    actual.onNext(t);
                }, next, TimeUnit.MILLISECONDS);
            }
        }

        @Override
        public void onError(Throwable e) {
            worker.schedule(() -> {
                actual.onError(e);
                unsubscribe();
            });
        }

        @Override
        public void onCompleted() {
            long next = lastTime - worker.now();
            worker.schedule(() -> {
                actual.onCompleted();
                unsubscribe();
            }, next, TimeUnit.MILLISECONDS);
        }

        @Override
        public void setProducer(Producer p) {
            actual.setProducer(p);
        }
    }

    public static void main(String[] args) {
        Observable.range(1, 5)
        .concatWith(Observable.just(6).delay(6500, TimeUnit.MILLISECONDS))
        .concatWith(Observable.range(7, 4))
        .lift(new SpanOut<>(1, TimeUnit.SECONDS, Schedulers.computation()))
        .timeInterval()
        .toBlocking()
        .subscribe(System.out::println);
    }
}