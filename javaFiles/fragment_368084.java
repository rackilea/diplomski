public final class Singleton implements Cloneable, Serializable {
    private static AtomicInteger counter = new AtomicInteger(1);


    public static Singleton getInstance() {
        if (counter.getAndIncrement() % 2 == 0) {
            return EvenHelper.instance;
        } else {
            return OddHelper.instance;
        }
    }

    private static class EvenHelper {
        //not initialized until the class is used in getInstance()
        static Singleton instance = new Singleton();
    }

    private static class OddHelper {
        //not initialized until the class is used in getInstance()
        static Singleton instance = new Singleton();
    } 
}