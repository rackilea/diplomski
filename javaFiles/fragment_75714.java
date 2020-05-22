spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
    @Override
    public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
        ListItem item = list.get(position)
        adapter.getFilter().filter(item.getType());
    }

    @Override
public void onNothingSelected(AdapterView<?> parentView) {
        // your code here
    }
});