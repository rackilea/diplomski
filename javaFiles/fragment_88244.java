public class RandomsAdapter extends BaseAdapter {

    private Map<Integer, Random> randoms;

    public RandomsAdapter(Map<Integer, Random> randoms) {
        this.randoms = randoms;
    }

    public void updateRandoms(Map<Integer, Random> randoms) {
        this.randoms = randoms;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return randoms.size();
    }

    @Override
    public Random getItem(int position) {
        return randoms.get(position);
    }

    @Override
    public long getItemId(int position) {
        // we won't support stable IDs for this example
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = createNewView();
        }
        update(view, songs.get(position));
        return view;
    }

    private View createNewView() {
        // TODO: create a new instance of your view and return it
        return null;
    }

    private void update(View view, Random random) {
        // TODO: update the rest of the view
    }

}