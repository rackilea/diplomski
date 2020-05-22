import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class SamplingFromSet {

    public static void main(String[] args) {
        Set<String> population = new TreeSet<>();

        /*
         * Populate the set
         */
        final int popSize = 17;
        for (int i=0; i<popSize; i++) {
            population.add(getRandomString());
        }

        List<String> sample 
            = sampleFromPopulation(population, 3 /*sampleSize */);

        System.out.println("population is");
        System.out.println(population.toString());
        System.out.println("sample is");
        System.out.println(sample.toString());

    }


    /**
     * Pick some samples for a population
     * @param population
     * @param sampleSize - number of samples
     * @return
     */
    private static <T> 
    List<T> sampleFromPopulation(Set<T> population
                                    , int sampleSize) {
        float sampleProb = ((float) sampleSize) / population.size();
        List<T> sample = new ArrayList<>();
        Iterator<T> iter = population.iterator();
        while (iter.hasNext()) {
            T element = iter.next();
            if (random.nextFloat()<sampleProb) {
                /*
                 * Lucky Draw!
                 */
                sample.add(element);
            }
        }
        return sample;
    }


    private static Random random = new Random();    

    private static String getRandomString() {
        return String.valueOf(random.nextInt());
    }
}