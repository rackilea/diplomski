protected class MyListAdapter extends ArrayAdapter<String> {
    private int layout;
    private List<String> names;
    private String[] ids;

    private MyListAdapter(Context context, int resource, List<String> names, String[] ids) {
        super(context, resource, names);
        layout = resource;
        this.names = names;
        this.ids = ids;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ...
        viewholder.delButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int deleteId = Integer.parseInt(ids[position]);// the "position" variable needs to be set to "final" in order to access it in here.
                idToDelete(deleteId);
                names.remove(position);
                notifyDataSetChanged();
            }
        });
        ....
    }
}