public class Scratch1 {
    public static void main(final String[] args) {
        final Map<String, Boolean> map = new WeakHashMap<>();

        String b = new String("B");
        map.put(b, true);
        b = null;

        System.gc();

        // map not internally accessed at this point
        System.out.println(map.isEmpty());

        // let's access the Map's internals (and hopefully coerce
        // it into removing no-longer-referenced keys)
        System.out.println(map.keySet()
                              .isEmpty());

        // map HAS now been accessed
        System.out.println(map.isEmpty());
    }

}