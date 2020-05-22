import java.util.Random;
import java.util.concurrent.Executor;
import java.util.function.Consumer;

public class DataProducer extends Thread {

    private final Consumer<MyDataClass> dataConsumer ;
    private final Executor updateExecutor ;

    public DataProducer(Consumer<MyDataClass> dataConsumer, Executor updateExecutor) {
        this.dataConsumer = dataConsumer ;
        this.updateExecutor = updateExecutor ;
        setDaemon(true);
    }

    @Override
    public void run()  {
        Random rng = new Random();
        try {
            while (true) {
                MyDataClass data = new MyDataClass(rng.nextInt(100));
                updateExecutor.execute(() -> dataConsumer.accept(data));
                Thread.sleep(rng.nextInt(1000) + 250);
            } 
        } catch (InterruptedException e) {
            // Ignore and allow thread to exit
        }
    }
}