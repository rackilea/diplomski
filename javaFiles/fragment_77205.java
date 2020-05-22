public class House<T> {

    static <E> void live(House<E> a) {}

    static {
        new House<Integer>() {
            {
                this.live(new House<String>());
            }
        };
    }

}