import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;

import java.util.ArrayList;
import java.util.List;

public class ListGenerator extends Generator<List<Integer>> {

    private static final int MAX_VALUE = 100;
    private static final GenerationStatus.Key<Integer> PREVIOUS_KEY = new GenerationStatus.Key<>("previous", Integer.class);

    @SuppressWarnings("unchecked")
    public ListGenerator() {
        super((Class<List<Integer>>) (Class) List.class);
    }

    public List<Integer> generate(SourceOfRandomness sourceOfRandomness, GenerationStatus generationStatus) {
        List<Integer> result = new ArrayList<>();

        int previous = generationStatus.valueOf(PREVIOUS_KEY).orElse(MAX_VALUE);
        int current = sourceOfRandomness.nextInt(previous);

        if (current > 0) {
            result.add(current);

            generationStatus.setValue(PREVIOUS_KEY, current);
            Generator<List<Integer>> listGen = gen().make(ListGenerator.class);
            result.addAll(listGen.generate(sourceOfRandomness, generationStatus));
            generationStatus.setValue(PREVIOUS_KEY, null);
        }

        return result;
    }
}