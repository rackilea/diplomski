import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class CandidateCode {

    public static void main(String[] args) {
        List<String> ListA = Arrays.asList("A", "B");
        List<String> ListX = Arrays.asList("X", "Y");
        List<String> ListL = Arrays.asList("L", "M");
        List<String> collect = ListA.stream().flatMap(a -> ListX.stream().flatMap(x -> ListL.stream().map(l -> a + "_" + x + "_" + l))).collect(Collectors.toList());
        collect.forEach(System.out::println);
    }
}