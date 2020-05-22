public class DemoDll {
    private static boolean running = true;
    private static DgtebdllLib dll = null;

    String status;
    String scan;

    /**
     * Callback implementation function for the received status
     */
    private DgtebdllLib.CallbackFunctionCharPtr getStatus
     = new DgtebdllLib.CallbackFunctionCharPtr() {
        @Override
        public void callback(Pointer data) {
            status = data.getString(0);
            System.out.println("Received status: " + status);
        }
    }; 

    /**
     * Callback implementation function for the evaluation of the received scan
     */
    private DgtebdllLib.CallbackFunctionCharPtr getScan
     = new DgtebdllLib.CallbackFunctionCharPtr() {
        @Override
        public void callback(Pointer data) {
            scan = data.getString(0);
            System.out.println("Received a scan: " + scan);
        }
    };

    …