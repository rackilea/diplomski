public class MyActivity extends Activity {
    private static final String THING = "THING";

    private String thing;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState==null) {
            // First time here (since we last backed out at least)
            thing = initializeThing(); // somehow we init it
        } else {
            // Rehydrate this new instance of the Activity
            thing = savedInstanceState.getString(THING);
        }

        String thing = app.getThing();
    }

    protected void onSaveInstanceState(Bundle outState) {
        outState.putString(THING, thing);
    }
}