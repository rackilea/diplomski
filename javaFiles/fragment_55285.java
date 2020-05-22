public class StartCalc implements OnSharedPreferenceChangeListener {
static final String TAG = "StartCalc";

Date time_o, time_f;
float money_o = 0, money_f = 0, hoursToday = 0, hoursTotal = 0, payscale;
SharedPreferences prefs;
private Context context;

public StartCalc(Context context) {
    this.context = context;
    prefs = PreferenceManager.getDefaultSharedPreferences(context);
    prefs.registerOnSharedPreferenceChangeListener(this);

    payscale = prefs.getFloat("PAYSCALE", 0);
}

public float calculateWeekly() { //its good practice to start method names with lower case

        Log.d(TAG, "Calculating normaltime pay");
        float pay = 10 * payscale; // testing with 10 instead of hours
        // total
        Log.d(TAG, Double.toString(payscale)); //always getting 0.0
        return pay;
}