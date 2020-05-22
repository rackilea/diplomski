import java.util.Map;

public class Calculator2 extends Calculator {

    public int calculate(Map<String, Integer> request) {
        return -1;
    }

    @Override
    public int fitnessFor(Map<String, Integer> request) {
        int fitness = -1;
        Integer price = request.get("price");
        if (price == null)
            return fitness;

        if (price < 5)
            fitness += weights.get("price");

        Integer gender = request.get("gender");
        if (gender == null)
            return fitness;

        if (gender == 1)
            fitness += weights.get("gender");

        return fitness;
    }

    public String toString() { return "Calculator2"; }  
}