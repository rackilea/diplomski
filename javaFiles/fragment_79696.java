public class Settings extends NavigationMenu 
    {
        @Override
        protected void onCreate(Bundle savedInstanceState) 
        {
            super.onCreate(savedInstanceState);
            LinearLayout container = (LinearLayout)findViewById(R.id.container);
            View settingsView = getLayoutInflater().inflate(R.layout.settings, null);
            container.addView(settingsView);
        }
    }