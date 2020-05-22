public class CActivity extends Activity 
{
  GridView gridView; 

   public void onCreate(Bundle savedInstanceState) 
            {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.cactivity);
    initComponent();
             gridView.setOnItemClickListener(new OnItemClickListener()
            {
              public void onItemClick(AdapterView<?> parent, View v,
                int position, long id) {
                  switch (position) {
                case 0://do the same for your remaining items
                    Intent myIntent = new Intent(getApplicationContext(), Abc.class);
                    startActivity(myIntent);
                    break;

                default:
                    break;
                }
              }
            //finish();
        }
    });
}
       private void initComponent() 
       {
         gridView = (GridView) findViewById(R.id.month_gridView);
         }