public class SouthIndian extends Activity {
ItemListBaseAdapter _itemListAdapter;
ArrayList<Recipedetails> results = new ArrayList<Recipedetails>();           
Recipedetails item_details = new Recipedetails();
ArrayList<Recipedetails> image_details = new ArrayList<Recipedetails>();
ListView lv1;
 @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        lv1 = (ListView) findViewById(R.id.listV_main);
        lv1.setOnItemClickListener(new OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> a, View v, int position, long id) {

                        Recipedetails item_details = new Recipedetails();
                        item_details = results.get(position);
                        //Object o = lv1.getItemAtPosition(position);

                      //  Recipedetails obj_itemDetails = (Recipedetails)o;
                        //Toast.makeText(SouthIndian.this, "You have chosen : " + " " +      obj_itemDetails.getName(), Toast.LENGTH_LONG).show();

                        Toast.makeText(SouthIndian.this, "You have chosen : " + " " +      item_details.getName(), Toast.LENGTH_LONG).show();

                        switch(item_details.getImageNumber())
                        {
                            case 1:
                                 Intent newActivity = new Intent(SouthIndian.this,AndroidTabLayoutActivity.class);    
                                 startActivity(newActivity);
                                break;

                            case 2:
                                Intent new1Activity = new Intent(SouthIndian.this,AndroidTabLayoutActivity1.class);    
                                startActivity(new1Activity);
                                break;

                            case 3:
                                Intent new2Activity = new Intent(SouthIndian.this,AndroidTabLayoutActivity2.class);    
                                startActivity(new2Activity);
                                break;

                            case 4:
                                Intent new3Activity = new Intent(SouthIndian.this,AndroidTabLayoutActivity3.class);    
                                startActivity(new3Activity);
                                break;        

                           default:
                                   Toast.makeText(SouthIndian.this, "Wrong Input", Toast.LENGTH_LONG).show();
                        }

                }
        });


    }

    // THIS IS WHAT IT SHOULD LOOK LIKE MORE OR LESS. THIS IS AS MUCH AS I CAN HELP

    private void refreshYourAdapter(final ArrayList<Recipedetails> items) {
         //this is what I meant. The error clearly states you are not updating the adapter on the UI thread
         runOnUiThread(new Runnable() {
             public void run() {
                 _itemListAdapter.refreshAdapter(items);
             }
         });
    }

    private ArrayList<Recipedetails> GetSearchResults(){
        /*ArrayList<Recipedetails> results = new ArrayList<Recipedetails>();           
        Recipedetails item_details = new Recipedetails();*/

        item_details.setName("Vegterian");
        item_details.setItemDescription("Recipes made by raw materials");
            item_details.setImageNumber(1);
        results.add(item_details);

        item_details = new Recipedetails();
        item_details.setName("Non-Vegterian");
        item_details.setItemDescription("Flesh of sweet animals");
        item_details.setImageNumber(2);
        results.add(item_details);

        item_details = new Recipedetails();
        item_details.setName("Pickels");
        item_details.setItemDescription("Touchable dish  by Homemade");
        item_details.setImageNumber(3);
        results.add(item_details);

        item_details = new Recipedetails();
        item_details.setName("Soups");
        item_details.setItemDescription("Startup for our food");
            item_details.setImageNumber(4);
        results.add(item_details);

        return results;
    }

    @Override
    protected void onResume() {
        super.onResume();
        _itemListAdapter = new ItemListBaseAdapter(this, image_details);
        refreshYourAdapter(GetSearchResults());
        lv1.setAdapter(_itemListAdapter);

    }