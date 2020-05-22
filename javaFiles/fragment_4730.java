import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public class TestCode {
    static final AtomicInteger sequence = new AtomicInteger();
    static final SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD:mm:ss:SSS");

    public static void main(String[] args) {
        String name = getUniqueName();
        System.out.println(name);
    }
    private static String getUniqueName() {
        String dateStr = sdf.format(new Date());
        String name = dateStr + "_" + sequence.incrementAndGet() + "_" + UUID.randomUUID() + ".jpg";
        return name;
    }
}