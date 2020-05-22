public class SeeAllEntriesActivity extends ListActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_entries);

        ActivitiesObjects ao = (ActivitiesObjects)this.getApplication();
        List<Customer> listOfCostumer = ao.getListOfCustomers();

        ListAdapter listAdapter = new ArrayAdapter(this, R.layout.activity_all_entries, listOfCostumer);
        // no need to fetch list view instance
        // ListView listViewCustomer = (ListView) findViewById(R.id.listViewCustomer);
        setListAdapter(listAdapter);
    }
}