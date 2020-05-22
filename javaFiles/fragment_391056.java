import java.util.*;

public class SortList {
    public static void main(String[] args) {
        List<Member> list = Arrays.asList(
            new Member( 1, "A"),
            new Member( 3, "C"),
            new Member(26, "Z"),
            new Member( 4, "D")
        );

        List<Member> order = Arrays.asList(
            new Member(4, "D"),
            new Member(3, "C"),
            new Member(2, "B"),
            new Member(1, "A")
        );

        sortBasedOn(list, order);

        list.stream().forEach(System.out::println);
    }

    public static <E> void sortBasedOn(List<E> toSort, List<E> ref, Comparator<E> comparator) {
        Collections.sort(toSort, comparator);
    }

    public static void sortBasedOn(List<Member> toSort, List<Member> ref) {
        sortBasedOn(toSort, ref, (left, right) -> {
            Optional<Member> foundLeft = ref.stream().filter(x -> x.getMemberId() == left.getMemberId()).findFirst();
            Optional<Member> foundRight = ref.stream().filter(x -> x.getMemberId() == right.getMemberId()).findFirst();
            if (!foundLeft.isPresent()) return 1;
            if (!foundRight.isPresent()) return -1;
            return Integer.compare(ref.indexOf(foundLeft.get()), ref.indexOf(foundRight.get()));
        });
    }
}