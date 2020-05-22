// client-side
LogServiceAsync logService = GWT.create(LogService.class);

GWT.setUncaughtExceptionHandler(new GWT.UncaughtExceptionHandler() {

    @Override
    public void onUncaughtException(final Throwable ex) {
        // wrapping throwable in SerializableThrowable to preserve 
        // causes and stack traces upon serialization
        SerializableThrowable serializableEx = new SerializableThrowable(ex);
        // sending instance of SerializableThrowable to server
        logService.log(serializableEx, callbackCodeDoesntMatter);
    }
}

// server-side
public class LogServiceServlet extends RemoteServiceServlet implements LogService {

    @Override
    public void log(final SerializableThrowable ex) {
        // getting original instance Throwable with preserved
        // causes and stack traces
        Throwable originalThrowable = ex.getThrowable();
        originalThrowable.printStackTrace();
    }
}