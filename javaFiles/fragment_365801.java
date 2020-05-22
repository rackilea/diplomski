list.setOnItemClickListener(new OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view,
        int position, long id) {

        TextView fact = (TextView) view.findViewById(R.id.c_id);
        Log.d("ListItem Clicked", "id: " + id + " position: "
        + position + " artist " + fact.getText());
    }
});