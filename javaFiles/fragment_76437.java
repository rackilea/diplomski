public class YourActivity implements NotificationCenter.NotificationCenterDelegate {

    @Override
    public void onPause() {
        NotificationCenter.getInstance().removeObserver(this, NotificationCenter.updateActivity);
        super.onPause();
    }

    @Override
    public void onResume() {
        NotificationCenter.getInstance().addObserver(this, NotificationCenter.updateActivity);
        super.onResume();
    }

    @Override
    public void didReceivedNotification(int id, Object... args) {
        if (id == NotificationCenter.updateActivity) {
            // do something with your activity, your service called this
        }
    }
}