import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class App {

    private <T> List<Double> foo(List<T> some) {
        return some.stream().map(item -> Double.class.cast(item)).collect(Collectors.toList());
    }

    private <T> List foo(List<T> some, Class<T> klass) {
        if (List.class.isAssignableFrom(klass)) {
            List result = new ArrayList<>();
            for (T item : some) {
                result.add(foo(List.class.cast(item), item.getClass()));
            }
            return result;
        } else {
            return foo(some);
        }
    }
}