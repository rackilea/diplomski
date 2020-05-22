public class List extends AppCompatActivity{
    String itemURL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Bundle itemData = getIntent().getExtras();
        if(itemData==null){
            return;
        }

        //Gets URL
        itemURL = itemData.getString("itemURL");
        int listSize=new Product(itemURL).getListSize();  // this doesn't do anything meaningful for you
        System.out.println(listSize);
    }
}