import java.util.HashMap;
import java.util.Map;

public class Main {

    interface Function {
        int function(int x);
    }

    public static void main(String[] args) {

        Map<String, Function> status = new HashMap<>();

        status.put("BOOK", (x) -> x);
        status.put("ISSUING", (x) -> x * 2);
        status.put("RETRYING", (x) -> x * 3);

        for (Map.Entry<String, Function> entry : status.entrySet()) {
            Function f = entry.getValue();
            System.out.printf("status %s call %s result: %d\n", entry.getKey(), entry.getValue(), f.function(2));
        }

    }
}