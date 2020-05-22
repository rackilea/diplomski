class CustomAdapter extends SimpleAdapter {

    public CustomAdapter(Context context, List<? extends Map<String, ?>> data, int resource, String[] from, int[] to) {
        super(context, data, resource, from, to);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = super.getView(position, convertView, parent);

        Map<String, Object> item = (Map<String, Object>) getItem(position);
        if ("male".equals(item.get("gender").toString())) {
            view.setBackgroundColor(R.color.male);
        } else {
            view.setBackgroundColor(R.color.female);
        }

        return view;
    }
}