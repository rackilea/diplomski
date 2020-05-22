@Override
public void onConfigurationChanged(Configuration newConfig) {
    super.onConfigurationChanged(newConfig);
    if(adapter!=null)
    {
        categories = dataSource.getAllCategories();
        adapter.notifyDataSetChanged();
    }
}