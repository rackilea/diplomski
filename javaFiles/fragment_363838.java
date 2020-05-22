private static final String BOOT_COMPLETED =
        "android.intent.action.BOOT_COMPLETED";
private static final String QUICKBOOT_POWERON =
        "android.intent.action.QUICKBOOT_POWERON";

@Override
public void onReceive(Context context, Intent intent) {

    // Get id & message from Intent
    int notificationId = intent.getIntExtra("notificationId", 0);
    String message = intent.getStringExtra("text");

    String action = intent.getAction();
    if (BOOT_COMPLETED.equals(action) ||
            QUICKBOOT_POWERON.equals(action)) {

        Intent service = new Intent(context, BootService.class);

        intent.putExtra("notificationId", notificationId);
        intent.putExtra("text", message);

        context.startService(service);
    }
    }