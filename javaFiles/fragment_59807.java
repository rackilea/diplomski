public class MyAdapter extends RecyclerView.Adapter<Item> {

  final boolean[] checkedArr;

  public MyAdapter(List<Item> list) {
    checkedArr = new boolean[list.size()];
    // Filling all the items as unchecked by default
    Arrays.fill(checkedArr, false);
  }

  @Override public void onBindViewHolder(Item holder, int position) {
    // You have removed the listener in `onViewRecycled`
    // Thus, this `setChecked()` won't cause any listener to be fired
    holder.checkbox.setChecked(checkedArr[holder.getAdapterPosition()]);
    holder.checkbox.setOnCheckedChangeListener(
        (buttonView, isChecked) -> {
          // Retaining checked state in the array
          checkedArr[holder.getAdapterPosition()] = isChecked;
        });
  }

  @Override public void onViewRecycled(Item holder) {
    super.onViewRecycled(holder);
    // When view is being recycled remove the listener
    holder.checkbox.setOnCheckedChangeListener(null);
  }
  ...
}