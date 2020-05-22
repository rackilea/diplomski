public class MainActivity extends ListActivity {
    DBTools dbTools = new DBTools(this);

    ArrayList<HashMap<String, String>> receiverList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActionBar().hide();
        setContentView(R.layout.activity_main);

        receiverList = dbTools.getAllReceivers();
        dbTools.close();
        ListView listView = getListView();
        if(receiverList.size() != 0) {
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int index, long id) {
                    view.setBackgroundColor(Color.RED);
                    TextView receiverIdTextView = (TextView) view.findViewById(R.id.receiverId);
                    selectionId = Integer.valueOf(receiverIdTextView.getText().toString());
                    ((SimpleAdapter) getListAdapter()).notifyDataSetChanged();
                 }

            });

            SimpleAdapter adapter = new SimpleAdapter(MainActivity.this,receiverList, R.layout.receiver_entry, new String[] { "receiverId","receiverName", "fullPath"}, new int[] {R.id.receiverId, R.id.receiverName, R.id.fullPath}) {
                @Override
                public View getView (int position, View convertView, ViewGroup parent) {
                    View view = super.getView(position, convertView, parent);
                    TextView receiverIdTextView = (TextView) view.findViewById(R.id.receiverId);
                    if(receiverIdTextView.getText().toString().equals(String.valueOf(selectionId))) {
                        view.setBackgroundColor(Color.RED);
                    } else {
                        view.setBackgroundColor(Color.WHITE);
                    }
                    return view;
                }
            };
            setListAdapter(adapter);
        }
    }
}