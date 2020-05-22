@Override
public void onViewCreated(View view, Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    mRecipeListView = this.getListView();
    mRecipeListView.setOnItemLongClickListener(new ListView.OnItemLongClickListener() {

        @Override
        public boolean onItemLongClick(AdapterView<?> arg0, View view, int position, long row_id) {
            // Process the long-click
        }
    });
}