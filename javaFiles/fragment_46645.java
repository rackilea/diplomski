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