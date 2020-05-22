import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class LazyInitRace {

    public class ExpensiveObject {
        public ExpensiveObject() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
    }

    private ExpensiveObject instance = null;

    public ExpensiveObject getInstance() {
        if (instance == null)
            instance = new ExpensiveObject();
        return instance;
    }

    public static void main(String[] args) {
        final LazyInitRace lazyInitRace = new LazyInitRace();

        FutureTask<ExpensiveObject> target1 = new FutureTask<ExpensiveObject>(
                new Callable<ExpensiveObject>() {

                    @Override
                    public ExpensiveObject call() throws Exception {
                        return lazyInitRace.getInstance();
                    }
                });
        new Thread(target1).start();

        FutureTask<ExpensiveObject> target2 = new FutureTask<ExpensiveObject>(
                new Callable<ExpensiveObject>() {

                    @Override
                    public ExpensiveObject call() throws Exception {
                        return lazyInitRace.getInstance();
                    }
                });
        new Thread(target2).start();

        try {
            System.out.println(target1.get() == target2.get());
        } catch (InterruptedException e) {
        } catch (ExecutionException e) {
        }
    }
}