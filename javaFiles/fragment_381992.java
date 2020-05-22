import java.util.Map;

public class Calculator1 extends Calculator {

    public int calculate(Map<String, Integer> request) {
        return -1;
    }

    @Override
    public int fitnessFor(Map<String, Integer> request) {
        int fitness = -1;
        Integer price = request.get("price");
        if (price == null)
            return fitness;

        if (price > 10)
            fitness += weights.get("price");

        return fitness;
    }

    public String toString() { return "Calculator1"; }
}