import java.util.List;

class ImmutableSet<T>
{
}
public class ParametersTest
{
    public static void main(String[] args)
    {
        List<String> list0 = null;
        List<String> list1 = null;
        of(list0, list1);
    }

    @SuppressWarnings("unchecked")
    public static <E> ImmutableSet<E> of(E e1, E e2) {
        return create(e1, e2);
    }

    public static <E> ImmutableSet<E> of(E... elements) {
        return create(elements);
    }

    private static <E> ImmutableSet<E> create(E... elements) 
    {
        return null;
    }

}