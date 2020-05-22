public class App {
    public static void main(String[] args) {
        Generic genericFirst1 = toGeneric(Specialized1.FIRST);
        Generic genericFirst2 = toGeneric(Specialized2.FIRST);
        assert genericFirst1 == genericFirst2;

        Specialized1 specialized1 = toSpecialized(Generic.SECOND, Specialized1.class);
        assert specialized1 == Specialized1.SECOND;
    }

    private static <T extends Enum<?>>T toSpecialized(Generic v, Class<T> specialized1Class) {
        try {
            return (T) specialized1Class.getField(v.name()).get(null);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        return null;
    }

    private static Generic toGeneric(Enum<?> e) {
        return Generic.valueOf(e.name());
    }

    enum Generic {
        FIRST, SECOND
    }

    enum Specialized1 {
        FIRST, SECOND
    }

    enum Specialized2 {
        FIRST, SECOND
    }

}