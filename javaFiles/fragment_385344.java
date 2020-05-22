public interface StatusBarHider {
    void hideStatusBar(final Activity activity);
}

public class DefaultStatusBarHider implements StatusBarHider {
    @Override
    public void hideStatusBar(final Activity activity) {
        activity.requestWindowFeature(Window.FEATURE_NO_TITLE);
        activity.getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
}

// ex; Possibly Guice or Dagger for injection
public class MainActivity extends Activity {
    @Inject
    private StatusBarHider hider;
    ...
}