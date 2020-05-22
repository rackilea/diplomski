public class Search extends ListActivity {
    private String[] l1;
    private String[] l2;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);
        ArrayList<Map<String, String>> list = buildData();
        String[] from = { "name", "purpose" };
        int[] to = { android.R.id.text1, android.R.id.text2 };
        SimpleAdapter adapter = new SimpleAdapter(this, list, android.R.layout.simple_list_item_2, from, to);
        setListAdapter(adapter);
    }

    private ArrayList<Map<String, String>> buildData() {
        l1 = getResources().getStringArray(R.array.items);
        l2 = getResources().getStringArray(R.array.collections);
        Integer i;
        int to = l1.length;
        ArrayList<Map<String, String>> list = new ArrayList<Map<String, String>>();     
        for(i=0;i < to;i++){
        list.add(putData(l1[i], l2[i]));
        }
        return list;
    }

    private HashMap<String, String> putData(String name, String purpose) {
        HashMap<String, String> item = new HashMap<String, String>();
        item.put("name", name);
        item.put("purpose", purpose);
        return item;
    }
}