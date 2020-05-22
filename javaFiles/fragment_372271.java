package test;

public class TestMain {

    public static void main(String args[]) throws Exception {
        try {
            apiCall();
        } catch(Exception e) {
            e.printStackTrace();
        }

    }

    public static void apiCall() throws Exception {
        logAndThrow();

    }

    public static void logAndThrow() throws Exception {
        Exception e = new Exception();
        StackTraceElement[] cleanedUpStackTrace = new StackTraceElement[e.getStackTrace().length -1];
        // Eliminate this mehod i.e. logAndThrow's stack trace entry (i.e. the first one) in cleanedUpStackTrace
        System.arraycopy(e.getStackTrace(), 1, cleanedUpStackTrace, 0, cleanedUpStackTrace.length);
        for(StackTraceElement ste : cleanedUpStackTrace) {
            System.out.println(ste.getMethodName());
        }

        e.setStackTrace(cleanedUpStackTrace);
        throw e;

    }
}