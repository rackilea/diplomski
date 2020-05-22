@Override
public MyAdapter.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    ViewDataBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.recycler_item,
            parent, false);
    return new MyHolder(binding.getRoot());
}