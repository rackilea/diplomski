public class EnumTest {
    public enum Runnables implements Runnable {
        HELLO {
            @Override
            public void run() {
                System.out.print("Hello, ");
            }
        },
        WORLD {
            @Override
            public void run() {
                System.out.println("world!");
            }
        };
    }

    public static <T extends Enum<T> & Runnable> void getEnumeration(Class<T> myEnum) {
        for (Runnable runnable : myEnum.getEnumConstants())
            runnable.run();
    }

    public static void main(String[] args) {
        getEnumeration(Runnables.class);
    }
}