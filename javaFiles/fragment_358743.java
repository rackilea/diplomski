public class DemoDll {
    private static boolean running = true;
    private static DgtebdllLib dll = null;

    static class StringRef implements DgtebdllLib.CallbackFunctionCharPtr() {
        String value;

        @Override
        public void callback(Pointer data) {
            value = data.getString(0);
            System.out.println("Received: " + value);
        }
    }
    StringRef status;
    StringRef scan;

    …