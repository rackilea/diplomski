public class Test<T extends Parent> {

    public static void main(String[] args) {
        new Test<Child>(Child.class);
    }

    private Test(Class<T> clazz) {
        System.out.println(Child.newInstance());
        try {
            System.out.println(clazz.getDeclaredMethod("newInstance").invoke(null));
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}