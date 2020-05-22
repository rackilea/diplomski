public class DistinctAndSort {
    static int COMPARE, EQUALS, HASHCODE;
    static class Tracker implements Comparable<Tracker> {
        static int SERIAL;
        int id;
        Tracker() {
            id=SERIAL++/2;
        }
        public int compareTo(Tracker o) {
            COMPARE++;
            return Integer.compare(id, o.id);
        }
        public int hashCode() {
            HASHCODE++;
            return id;
        }
        public boolean equals(Object obj) {
            EQUALS++;
            return super.equals(obj);
        }
    }
    public static void main(String[] args) {
        System.out.println("adjacent sorted() and distinct()");
        Stream.generate(Tracker::new).limit(100)
              .sorted().distinct()
              .forEachOrdered(o -> {});
        System.out.printf("compareTo: %d, EQUALS: %d, HASHCODE: %d%n",
                          COMPARE, EQUALS, HASHCODE);
        COMPARE=EQUALS=HASHCODE=0;
        System.out.println("now with intermediate operation");
        Stream.generate(Tracker::new).limit(100)
            .sorted().map(x -> x).distinct()
            .forEachOrdered(o -> {});
        System.out.printf("compareTo: %d, EQUALS: %d, HASHCODE: %d%n",
                          COMPARE, EQUALS, HASHCODE);
    }
}