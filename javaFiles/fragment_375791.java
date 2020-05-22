public class MenuClass extends Activity {

TinyDB tinyDB;    
    MyInAppPurchaseBilling myInAppPurchaseBilling = new MyInAppPurchaseBilling(MenuClass.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myInAppPurchaseBilling.onCreate();

    tinyDB= new TinyDB(MenuClass.this);
        if (!tinyDB.getBoolean(Constant.isAdsDisabled)) {
//do your work
        }
        setContentView(R.layout.activity_menu_class);
   }
}