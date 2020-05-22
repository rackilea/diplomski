public class Menu extends ListActivity
{
    public static final String EXTRA_PICTURE = "extra.picture.toshow";
    String classes[] = { "CoverSheet", "TreatmentProtocols", "EMSProcedures", 
            "DrugList", "EMSPolicies", "EMSTriageAndDestinationPlan", 
            "Appendices" };
    //in this array you store the drawable resource ids to show. 
    //you can change it to hold urls or other identifiers.
    int images[] = { R.drawable.coversheet, R.drawable.img2, R.drawable.img3, 
        R.drawable.img4, R.drawable.img5, R.drawable.img6, R.drawable.img7};

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(Menu.this, 
                android.R.layout.simple_list_item_1, classes));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id)
    {
        super.onListItemClick(l, v, position, id);
        String Menu = classes[position];
        try
        {
            Class firstClass = Class.forName("protocols.NashCounty." + Menu);
            Intent firstIntent = new Intent(Menu.this, firstClass);
            firstIntent.putExtra(EXTRA_PICTURE, images[position]);
            startActivity(firstIntent);
        }
        catch (ClassNotFoundException e)
        {
            Log.e("SAMPLE", "ClassNotFoundException ", e);
        }
        catch (Exception e)
        {
            Log.e("SAMPLE", "Exception ", e);
        }
    }
}