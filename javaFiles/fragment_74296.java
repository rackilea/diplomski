adapter.registerDataSetObserver(new DataSetObserver() {
    @Override
    public void onChanged() {
        super.onChanged();
        Log.d("Foo", adapter.getCount());
    }
});