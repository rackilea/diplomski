public class AlertListItemAdapter extends ParseQueryAdapter<AlertObject> {

    public AlertListItemAdapter(
            Context context,
            ParseQueryAdapter.QueryFactory<AlertObject> queryFactory,
            Fragment fragment) {
        super(context, queryFactory);
    }

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        Log.d("FOO", "item count: " + getCount());
    }

    @Override
    public View getItemView(AlertObject alertObject, View view, ViewGroup parent) {
        Log.d("FOO", "getItemView()");
        ...
    }

    ...
}