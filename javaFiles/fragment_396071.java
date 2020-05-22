import com.sun.jna;

public interface ServerErrorEvent implements Callback
{
    void invoke(long serverConnectionHandlerID, String errorMessage, int error, String returnCode, String extraMessage);
}