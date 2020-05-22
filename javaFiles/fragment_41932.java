import java.util.Arrays;
import java.util.List;

public class Generics {

    static List getObjects() {
        return Arrays.asList("one", 2, 3);
    }

    public static void main(String[] args) {
        List<String> list = getObjects();
        for (Object o : list) { // ClassCastException?
            System.out.println(o);
        }
    }
}