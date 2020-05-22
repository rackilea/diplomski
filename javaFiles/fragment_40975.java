// Not valid Java!
public enum EleType<T> {
    INTEGER(Integer.class, rand -> rand.nextInt()),
    CHARACTER(Character.class, rand -> (char) (rand.nextInt(26) + 'a'));

    private final Class<T> classType;
    private final Function<Random, T> creator;

    // Constructor and getters
}