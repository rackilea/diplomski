@Override
public View getView(int position, View convertView, ViewGroup parent) {
    if (inflater == null) {
        inflater = ((Activity) parent.getContext()).getLayoutInflater();
    }

    // Perform the binding

    ActivityTeamMessageListRowBinding binding = DataBindingUtil.getBinding(convertView);

    if (binding == null) {
        binding = DataBindingUtil.inflate(inflater, R.layout.my_activity_list_row, parent, false);
    }

    binding.setInfo(list.get(position));
    binding.executePendingBindings();

    // Return the bound view
    return binding.getRoot();
}