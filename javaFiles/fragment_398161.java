import java.util.HashSet;
import java.util.Set;

public class Test4 {

    public static void main(String[] args) {
        Integer[] arrayInt = {1, 2, 3, 1};

        Set<Integer> integers = new HashSet<Integer>();
        boolean hasDuplicates = false;

        for (Integer integerNumber : arrayInt) {
            if (!integers.add(integerNumber)) {
                hasDuplicates = true;
                break;
            }
        }

        System.out.println("Contains duplicates? " + hasDuplicates);
    }

}