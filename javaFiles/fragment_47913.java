ExampleClickAdapter clickAdapter = new ExampleClickAdapter(yourObjects);
clickAdapter.setOnEntryClickListener(new ExampleClickAdapter.OnEntryClickListener() {
    @Override
    public void onEntryClick(View view, int position) {
        // stuff that will happen when a list item is clicked
    }
});
recyclerView.setAdapter(clickAdapter);