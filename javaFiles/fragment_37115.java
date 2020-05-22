listView.setOnItemClickListener(new OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,long arg3) {
        view.setSelected(true);
        ... // Anything
    }
});