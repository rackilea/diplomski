public class ListAdapter extends ArrayAdapter<Item> {

 public ListAdapter(Context context, int textViewResourceId) {
super(context, textViewResourceId);
// TODO Auto-generated constructor stub
}

private List<Item> items;

public ListAdapter(Context context, int resource, List<Item> items) {

super(context, resource, items);

this.items = items;

}

@Override
public View getView(int position, View convertView, ViewGroup parent) {

View v = convertView;

if (v == null) {

    LayoutInflater vi;
    vi = LayoutInflater.from(getContext());
    v = vi.inflate(R.layout.listitemrow, listView, false);

}

 ...
return v;

}
}