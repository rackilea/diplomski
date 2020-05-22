public class MyActivity extends Activity 
{
    @Override protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate();
        Configuration config = getResources().getConfiguration();
        if (config.smallestScreenWidthDp >= 600) 
        {
            setContentView(R.layout.main_activity_tablet);
        } 
        else 
        {
            setContentView(R.layout.main_activity);
        }
    }
}