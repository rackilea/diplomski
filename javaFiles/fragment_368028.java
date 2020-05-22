public class Event extends java.util.EventObject {

    public static final Object UNKNOWN_SOURCE = new Object();

    public Event(String event, String value, String message, Object info) {
        super(UNKNOWN_SOURCE);

        mName = event;
        mValue = value;
        mMessage = message;
        mInfo = info;
    }