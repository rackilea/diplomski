class Main Activity {
// ...
private static native void publishNotification(String notification);
// Call it from your Java code as it has a proper implementation

//...
    if (newNotification) {
        publishNotification(notification);
    }
//...