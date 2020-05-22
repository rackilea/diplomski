public class Main {
    public static void main(String[] args) {
        Instrumentation inst = InstrumentHook.getInstrumentation();
        for (Class<?> clazz: inst.getAllLoadedClasses()) {
            System.err.println(clazz.getName());
        }
    }
}