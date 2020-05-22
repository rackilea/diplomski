import java.util.HashMap;
import java.util.Map;

public abstract class Calculator {
    public static Map<String, Integer> weights;
    static {
        weights = new HashMap<String, Integer>();
        weights.put("price", 10);
        weights.put("gender", 2);
        weights.put("geo", 5);
    }

    public abstract int calculate(Map<String, Integer> request);
    public abstract int fitnessFor(Map<String, Integer> request);
}