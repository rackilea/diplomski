public class SortActivity extends ListActivity {

private StupidAdapter stupidAdapter;
private List<String> list = new ArrayList<String>();

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    list.add("Android-a");
    list.add("Android-b");
    list.add("Android-c");
    list.add("BlackBerry-a");
    list.add("BlackBerry-b");
    list.add("BlackBerry-c");
    list.add("Windows-a");
    list.add("Windows-b");
    list.add("Windows-c");

    // keep in mind that from now on whatever changes you do on list is not reflected on the adapter.
    // the array adapter keeps its own internal data
    stupidAdapter = new StupidAdapter(this, list);
    setListAdapter(stupidAdapter);

}

@Override
public boolean onCreateOptionsMenu(final Menu menu) {
    new MenuInflater(this.getApplication()).inflate(R.menu.main_menu, menu);
    return super.onCreateOptionsMenu(menu);
}

@Override
public boolean onOptionsItemSelected(final MenuItem item) {
    final int id = item.getItemId();
    if (id == R.id.menu_main_sort_az) {
        stupidAdapter.sort(new Comparator<String>() {
            public int compare(String object1, String object2) {
                return object1.compareTo(object2);
            };
        });
    } else if (id == R.id.menu_main_sort_za) {
        stupidAdapter.sort(new Comparator<String>() {
            public int compare(String object1, String object2) {
                return object2.compareTo(object1);
            };
        });
    }
    stupidAdapter.notifyDataSetChanged();
    return true;
}

class StupidAdapter extends ArrayAdapter<String> {

    public StupidAdapter(Context context, List<String> list) {
        super(context, R.layout.list_item, list);
    }

    @Override
    public View getView(final int position, View row, final ViewGroup parent) {
        ViewHolder viewHolder;

        final String item = getItem(position);

        if (row == null) {
            row = getLayoutInflater().inflate(R.layout.list_item, parent, false);
            viewHolder = new ViewHolder(row);

            row.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) row.getTag();
        }

        viewHolder.refreshData(item);

        return row;
    }       

    class ViewHolder {
        TextView title;
        public ViewHolder(View row) {
            this.title = (TextView) row.findViewById(R.id.title);
        }
        public void refreshData(final String text) {
            this.title.setText(text);
        }
    }   

}

}