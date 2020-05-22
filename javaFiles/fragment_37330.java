public class AppUpdateReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(final Context context, final Intent intent) {

        switch (BuildConfig.VERSION_CODE){
            case 1:
                //DO something if the version code is 1.
                break;
            case 2:
                //DO something if the version code is 2.
                break;
            ...
            ...
        }
    }
}