import java.util.Comparator;
import java.util.Map;

public class CalcComparator implements Comparator<Calculator> {
    private Map<String, Integer> request;

    public CalcComparator(Map<String, Integer> request) {
        this.request = request;
    }

    @Override
    public int compare(Calculator c1, Calculator c2) {
        int c1Fitness = c1.fitnessFor(request);
        int c2Fitness = c2.fitnessFor(request);

        if (c1Fitness == c2Fitness)
            return 0;

        if (c1Fitness < c2Fitness)
            return 1;

        return -1;
    }
}