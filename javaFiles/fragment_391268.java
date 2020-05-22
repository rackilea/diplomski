public class MyLazySingleton() {
    private static class InstanceHolder {
        static MyLazySingleton INSTANCE = new MyLazySingleton();
    }

    public static MyLazySingleton getInstance() {
        return InstanceHolder.INSTANCE;
    }
}