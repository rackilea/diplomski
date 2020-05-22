import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;
import java.util.stream.Stream;

class Test{
    public static void main(String[] args){
        List<List<String>> totalList = new ArrayList<>();
        totalList.add(Arrays.asList("1.1","1.2","1.3"));
        totalList.add(Arrays.asList("2.1"));
        totalList.add(Arrays.asList("3.1","3.2"));
        Supplier<Stream<String>>[] sup = new Supplier[totalList.size()];

        for(int i = 0; i<totalList.size();i++){
            final int j = i;
            sup[i]= () -> totalList.get(j).stream();
        }

        Stream<String> result = cartesian((a, b) -> a+"|"+b, sup);
        result.forEach(System.out::println);
    }

    private static <T> Stream<T> cartesian(BinaryOperator<T> aggregator, Supplier<Stream<T>>... streams) {
    return Arrays.stream(streams)
        .reduce((s1, s2) -> 
            () -> s1.get().flatMap(t1 -> s2.get().map(t2 -> aggregator.apply(t1, t2))))
        .orElse(Stream::empty).get();
    }
}