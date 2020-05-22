public class Launcher {

    private static Launcher instance;

    private Launcher() {
        Launcher.instance = this;
    }

    public static Launcher instance() {
        if(instance == null) {
            instance = new Launcher();
        }
        return instance;
    }

    public void startTustanService(Activity currentActivity){
        Intent notificationIntent = new Intent(currentActivity, currentActivity.getClass());
        startServiceIntent.putExtra("notificationIntent", notificationIntent);

        currentActivity.startService(new Intent(currentActivity, TestService.class));
    }
}