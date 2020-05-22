public final class EleType<T> {
    public static final EleType<Integer> INTEGER = new EleType<>(Integer.class,
            rand -> rand.nextInt());
    public static final EleType<Character> CHARACTER = new EleType<>(Character.class,
            rand -> (char) (rand.nextInt(26) + 'a'));

    private final Class<T> classType;
    private final Function<Random, T> creator;

    private EleType(Class<T> classType, Function<Random, T> creator) {
        this.classType = classType;
        this.creator = creator;
    }

    // Getters
}