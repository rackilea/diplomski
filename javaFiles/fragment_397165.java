public class ActivityTo extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        String [] arrayCityBreak = getResources().getStringArray(R.array.citybreak);

        ArrayAdapter<String> adapterCityBreak = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayCityBreak);

        ListView myview = getListView();

        myview.setAdapter(adapterCityBreak);

    }
}