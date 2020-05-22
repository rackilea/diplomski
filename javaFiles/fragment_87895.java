public class MyAgent {
    public static void agentmain(final String args, final Instrumentation inst) {
        try {
            System.out.println("Agent loaded.");
        } catch (Exception e) {
            // Catch and handle every exception as they would
            // otherwise be ignored in an agentmain method
            e.printStackTrace();
        }
    }
}