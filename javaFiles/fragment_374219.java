import android.app.NotificationManager;
import android.content.Context;

@Override
protected void onResume() {
    super.onResume();

    // Removing All Notifications
    cancelAllNotifications();
}

private void cancelAllNotifications() {
    NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
    notificationManager.cancelAll();
}