import java.util.Arrays;
import java.util.stream.Collectors;

public class Capitalize {
    public static String stream(String text) {
        return Arrays.stream(text.split("\\s+"))
            .map(s -> s.substring(0,1).toUpperCase() + s.substring(1))
            .collect(Collectors.joining(" "));
    }

    public static void main(String...string) {
        System.out.println(stream("the simpson series"));
    }
}