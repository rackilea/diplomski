public class SmartApp extends Activity implements OnSharedPreferenceChangeListener {
   private SmartDBHelper dBHelper;
   public void onCreate(Bundle savedInstanceState) {
      //where i am wanting to create the database and tables
      dBHelper = new SmartDBHelper(getContext());
      // open to read and write
      dBHelper.getWritableDatabase();
      // or to read only
      // dBHelper.getReadableDatabase();
   }
}