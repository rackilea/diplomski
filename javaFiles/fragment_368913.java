public class StandardStructure<T> {

    public List<T> groupProceeds(Collection<? extends T> entities, Function<? super T, Integer> property) {
        int from = 10001;
        int to = 10070;
        int sum = 1010000;

        return buildGroup(entities, property, from, to, sum);
    }

    private List<T> buildGroup(Collection<? extends T> e,  Function<? super T, Integer> p, int from, int to, int sum) {
         /* Whatever that does */
    }
}