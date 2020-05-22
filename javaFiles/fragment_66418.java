public abstract class RecyclerViewAdapterBase<T, V extends View & ViewWrapper.Binder<T>> extends RecyclerView.Adapter<ViewWrapper<T, V>> {

    protected List<T> mItems = new ArrayList<T>();

    @Override
    public final ViewWrapper<T, V> onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewWrapper<T, V>(onCreateItemView(parent, viewType));
    }

    protected abstract V onCreateItemView(ViewGroup parent, int viewType);

    @Override
    public final void onBindViewHolder(ViewWrapper<T, V> viewHolder, int position) {
        V view = viewHolder.getView();
        T data = mItems.get(position);

    /*************************************************************/
    *       AT THIS POINT IT TRY TO SET A CLICK LISTENER     */
    /*************************************************************/
        setOnClickListener(view, data);

        view.bind(data);
    }

    @Override
    public int getItemCount() {
        return null == mItems ? 0 : mItems.size();
    }

    public void add(T item) {
        mItems.add(item);
        notifyDataSetChanged();
    }

    public void addAll(Collection<T> collection) {
        mItems.addAll(collection);
        notifyDataSetChanged();
    }

    public void clear() {
        mItems.clear();
    }


    /**
     * override this into child adapter to manage click event
     */
    public void setOnClickListener(View v, T item) {}
}