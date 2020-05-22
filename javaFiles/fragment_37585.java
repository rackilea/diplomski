import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Stream;

public class AnimalFactory {
    private final Map<String, Function<Animal, Object>> delegateFactories
        = new HashMap<String, Function<Animal,Object>>();

    public AnimalFactory withFactory(String type, Function<Animal, Object> factory) {
        delegateFactories.put(type, factory);
        return this;
    }

    public Object createAnimal(Animal animal) {
        return delegateFactories.get(animal.getType()).apply(animal);
    }
}