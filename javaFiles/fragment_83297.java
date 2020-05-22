public class TempClientFactory {
    public static IClient getInstance() {
        return ClientHolder.INSTANCE;
    }

    private static class ClientHolder {
        private static final TempClient INSTANCE = new TempClient();

        static {
            // You could do this here, as well, if it were more complicated
            //  than a one-line statement (e.g., requires try/catch):
            //INSTANCE = new TempClient();

            new TempScheduler().startScheduler();
        }
    }
}