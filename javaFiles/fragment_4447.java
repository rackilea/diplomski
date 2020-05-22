@Service
public class MyService {
    @Async //This annotation replaces building your own thread
    public void asyncLongOperation(Consumer<String> consumer) {
        String pie = calculatePieWhichIsShorterThanPi();
        consumer.accept(pie);
    }
}