class SomeActivity extends Activity {
    public static Context ctx;

    protected void onCreate(Bundle bundle) {
        // ...
        ctx = this;
        // ...
    }

    public static Context getLastSetContext() {
        return ctx;
    }
}