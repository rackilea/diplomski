@Override
public void onBindViewHolder(final ViewHolder holder, final int position) {
     holder.checkbox.setOnCheckedChangeListener(null);
     holder.checkbox.setChecked(movieItems.get(position).isCheck()); 
     holder.checkbox.setOnCheckedChangeListener(checkedListener);
}