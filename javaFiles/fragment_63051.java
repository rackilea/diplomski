import java.util.Random;
import java.util.function.Consumer;

public class DataProducer extends Thread {

    private final Consumer<MyDataClass> dataConsumer ;

    public DataProducer(Consumer<MyDataClass> dataConsumer) {
        this.dataConsumer = dataConsumer ;
        setDaemon(true);
    }

    @Override
    public void run()  {
        Random rng = new Random();
        try {
            while (true) {
                MyDataClass data = new MyDataClass(rng.nextInt(100));
                dataConsumer.accept(data);
                Thread.sleep(rng.nextInt(1000) + 250);
            } 
        } catch (InterruptedException e) {
            // Ignore and allow thread to exit
        }
    }
}