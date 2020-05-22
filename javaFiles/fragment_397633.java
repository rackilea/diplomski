/**
 * Sample activity for passing parameters through a static constructor
 * @author Chase Colburn
 */
public class ParameterizedActivity extends Activity {

    private static final String INTENT_KEY_PARAM_A = "ParamA";

    private static final String INTENT_KEY_PARAM_B = "ParamB";

    /**
     * Static constructor for starting an activity with supplied parameters
     * @param context
     * @param paramA
     * @param paramB
     */
    public static void startActivity(Context context, String paramA, String paramB) {
        // Build extras with passed in parameters
        Bundle extras = new Bundle();
        extras.putString(INTENT_KEY_PARAM_A, paramA);
        extras.putString(INTENT_KEY_PARAM_B, paramB);

        // Create and start intent for this activity
        Intent intent = new Intent(context, ParameterizedActivity.class);
        intent.putExtras(extras);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Extract parameters
        Bundle extras = getIntent().getExtras();
        String paramA = extras.getString(INTENT_KEY_PARAM_A);
        String paramB = extras.getString(INTENT_KEY_PARAM_B);

        // Proceed as normal...
    }
}