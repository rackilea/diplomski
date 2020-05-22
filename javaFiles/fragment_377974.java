public abstract class BaseActivity extends AppCompatActivity {

    private final Context context;

    public BaseActivity() {
        this.context = setContext();
    }

    protected abstract Context setContext();

    @Override
    public void onResume() {
        super.onResume();
        registerBroadcastReceiver();
    }

    @Override
    public void onPause() {
        super.onPause();
        unRegisterBroadcastReceiver();
    }

    // Declare your BroadcastReceiver here
    private class MyBroadcastReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            showAlertDialog(context);
        }
    }
}