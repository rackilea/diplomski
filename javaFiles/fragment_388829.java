public class MyFactory {
    private static final class Holder {
        private static final MyFactory instance = new MyFactory();
    }

    public static MyFactory getInstance() {
        return Holder.instance;
    }
}