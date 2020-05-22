listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
        ModelClass ref = (ModelClass) listview.getItemAtPosition(i);
        Toast.makeText(getActivity(), ref.getid, Toast.LENGTH_SHORT).show();
        return false;
    }
});