public class BaseJuiceApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
    SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);

        Locale locale = new Locale(pref.getString("lang_code","en"));
        Locale.setDefault(locale);
         Configuration conf = getBaseContext().getResources().getConfiguration(); 
        config.locale= locale;
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());


    }

}