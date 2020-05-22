public class TestActivity extends ListActivity { 
    private ArrayList<String> itemNameArray;
     private ArrayList<String> dateArray;
     private ListView listview;
     CustomListViewAdapter customListViewAdapter; 

    @Override 
    public void onCreate(Bundle savedInstanceState) { 
    super.onCreate(savedInstanceState);
     setContentView(R.layout.activity_test);
     registerForContextMenu(getListView());
 String root = Environment.getExternalStorageDirectory() + File.separator + "/ListTestFiles";
     getDir(root);

     listview = getListView();

     CustomListViewAdapter = new CustomListViewAdapter(this, itemNameArray, dateArray);
     listview.setAdapter(customListViewAdapter);
     }
     // End of onCreate code. class

     CustomListViewAdapter extends ArrayAdapter<String> { 
    ArrayList<String> nameArray;
     ArrayList<String> modifiedArray; CustomListViewAdapter(Context c, ArrayList<String> name, ArrayList<String> lastmod) {
     super(c, 0, name); 
     this.nameArray = name;
     this.modifiedArray = lastmod;
     } 
    public View getView(int position, View convertView, ViewGroup parent) { 
    LayoutInflater inflater=LayoutInflater.from(parent.get context());
     convertView = inflater.inflate(R.layout.layout_item_view, parent, false); 
    TextView myName; 
    TextView myLastMod;
     myName=(TextView) row.findViewById(R.id.rowtext);
     myName.setText(nameArray.get(position));
     myLastMod=(TextView) row.findViewById(R.id.textView6);
     myLastMod.setText(modifiedArray.get(position));
     return convertView;
     }
     }

     @Override
     public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) { 
    super.onCreateContextMenu(menu, v, menuInfo); 
    getMenuInflater().inflate(R.menu.context_menu, menu); 
    }

     @Override 
    public boolean onContextItemSelected(MenuItem itemMenu) {

    switch (itemMenu.getItemId()) { 
    case R.id.context_menu_rename:
     Toast.makeText(this, "Rename", Toast.LENGTH_SHORT).show();
     break; 
    case R.id.context_menu_delete: itemNameArray.remove(listView.getSelectedItemPosition());
    dateArray.remove(listView.getSelectedItemPosition()); customListViewAdapter.notifyDataSetChanged(); 
     break; 
    }
    return true;
     }
     }