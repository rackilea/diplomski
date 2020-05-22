package radium.rx;

import java.util.List;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.schedulers.Schedulers;

public class TryRx {

    public static Random RANDOM = new Random();

    public static void main(String[] arguments) throws Throwable {
        final List<Integer> inputs = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
        final ExecutorService threadPoolExecutor = Executors.newFixedThreadPool(2);

        Iterable<Integer> outputs = Observable.<Integer>from(inputs)
                .flatMap((Integer input) -> deferHeavyWeightStuff(input).subscribeOn(Schedulers.from(threadPoolExecutor)))
                .toBlocking()
            .toIterable();

        for (Integer output : outputs) {
            System.out.println(output);
        }

        threadPoolExecutor.shutdown();
    }

    public static void sleepQuietly(int duration, TimeUnit unit) {
        try {
            Thread.sleep(unit.toMillis(duration));
        } catch (InterruptedException e) {

        }
    }

    public static Observable<Integer> deferHeavyWeightStuff(final int input) {
        return Observable.defer(() -> Observable.just(doHeavyWeightStuff(input)));
    }

    public static int randomInt(int min, int max) {
        return RANDOM.nextInt((max - min) + 1) + min;
    }

    public static int doHeavyWeightStuff(int input) {
        sleepQuietly(randomInt(1, 5), TimeUnit.SECONDS);
        int output = (int) Math.pow(input, 2);
        return output;
    }

}