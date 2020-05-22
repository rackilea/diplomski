public class ListItemAdapter extends ArrayAdapter<ListItem>{


    public ListItemAdapter(Context context, List<ListItem> items) {
        super(context, 0, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Context context = getContext();
        ListItem item = getItem(position);
        View rootView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);


        TextView name = (TextView) rootView.findViewById(R.id.your_text_view_item);
        name.setText(item.name);

        return rootView;
    }
}