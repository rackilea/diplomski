public class Controller extends DeviceAdminReceiver {
    public Controller() {
        super();
    }

    void showToast(Context context, String msg) {
        String status = "Status";
        Toast.makeText(context, status, Toast.LENGTH_SHORT).show();

        //Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }
    ...
}