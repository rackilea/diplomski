public class MainActivity extends AppCompatActivity
    implements
        StoreEntryFragment.OnFragmentInteractionListener,
        RecipeeEntryFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DBHelper mDBHlpr = new DBHelper(this);
        if (DatabaseUtils.queryNumEntries(mDBHlpr.getWritableDatabase(),DBHelper.TBSTORE) < 1) {
            mDBHlpr.addStore("Rice",1.53f,10,1000,"The Rice Company",1);
            mDBHlpr.addStore("Bran",2.34f,100,500,"BranDed",25);
        }
        if(DatabaseUtils.queryNumEntries(mDBHlpr.getWritableDatabase(),DBHelper.TBRECIPEE) < 1) {
            mDBHlpr.addRecipee("RiceCrisps","Yucky",10,"This and that");
            mDBHlpr.addRecipee("Bran Flakes","Makes you go",5,"Flakes or something");
        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {
    }
}