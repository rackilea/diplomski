@Override
public void onBindViewHolder(final MyViewHolder holder, int position) {
    holder.final_list_TextView1.setText(finalListItems.get(position).getName());

    // remove the Listener before setting the checked state programmatically
    // and set all the attributes (checked state and background color) here
    holder.checkBox.setOnCheckedChangeListener(null);
    if(finalListItems.get(position).isChecked){
        holder.linearLayout.setBackgroundColor(Color.rgb(0, 225, 0));
        holder.checkBox.setChecked(true);
    }
    else{
        holder.linearLayout.setBackgroundColor(Color.rgb(255, 255, 255));
        holder.checkBox.setChecked(false);
    }
    holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            // Lint warning : don't use "final int position"
            int currentPosition = holder.getAdapterPosition();
            if (isChecked) {
                FinalListItem finalItemBefore = finalListItems.get(currentPosition);
                FinalListItem finalItemAfter = new FinalListItem(finalItemBefore.getName(),true);
                finalListItems.remove(finalItemBefore);
                finalListItems.add(finalItemAfter);
                notifyDataSetChanged();
            } else {
                finalListItems.get(currentPosition).setChecked(false);
                // no need to update the whole list since only one item has changed
                notifyItemChanged(currentPosition);
            }
        }
    });
}