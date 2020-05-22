public class Warnings {
    public static void main(final String[] args) {
        List<Class<? extends Enum<?>>> enums = new ArrayList<Class<? extends Enum<?>>>();
        enums.add(A.class);
        enums.add(B.class);
        for (Class<? extends Enum<?>> clazz : enums) {
            try {
                Switch s = valueOf(clazz, args[0]);
                s.toggle();
            } catch (IllegalArgumentException eee) {
            }
        }
    }

    private static Switch valueOf(final Class<? extends Enum<?>> enumClass, final String name) {
        Enum<?>[] enumConstants = enumClass.getEnumConstants();
        for (Enum<?> constant : enumConstants) {
            if (constant.name().equals(name)) {
                return (Switch) constant;
            }
        }
        throw new IllegalArgumentException(name + " is not a constant of enum class " + enumClass.getName());
    }
}