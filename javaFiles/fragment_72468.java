import java.util.ArrayList;
import java.util.List;

public class SupertypeMethod {
    public static void main(String[] args) {

        Integer integer = null;
        Number number = null;

        List<Number> numberList = null;
        List<Integer> integerList = null;

        // Always works:
        integer = fooTrivial(integer);
        number = fooTrivial(number);
        number = fooTrivial(integer);

        numberList = withList(numberList);
        //numberList = withList(integerList); // Does not work

        // Both work:
        numberList = withListAndBound(numberList);
        numberList = withListAndBound(integerList);
    }

    public static <T, U extends T> T fooTrivial(U u) {
        return u;
    }

    public static <T, U extends T> List<T> withListAndBound(List<U> u) {
        List<T> result = new ArrayList<T>();
        result.add(u.get(0));
        return result;
    }

    public static <T> List<T> withList(List<T> u) {
        List<T> result = new ArrayList<T>();
        result.add(u.get(0));
        return result;
    }

}