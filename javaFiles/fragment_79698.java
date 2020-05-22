public class Settings extends NavigationMenu 
    {
        @Override
        protected View createView()
        {
            LinearLayout container = (LinearLayout)findViewById(R.id.container);
            return getLayoutInflater().inflate(R.layout.settings, null);
        }
    }