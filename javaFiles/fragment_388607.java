public class NotificationHelper {
    public static void sendNotification(String id) throws Exception {
        // TODO: use an enum
        String message;
        switch (id) {
            case "mobile":
                message = "Created new account";
                break;
            case "email":
                message = "Hi, An account is created with our website using your email id. This is a notification regarding the same.";
                break;
            default:
                throw new Exception("id is neither phone number nor email id");
        }
        notify(id, message);
    }

    public static void notify(String id, String message){
        //Code to send notification
    }
}