public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements RecyclerViewItemEnabler{

    @Override
    public void onViewAttachedToWindow(RecyclerView.ViewHolder holder) {
        super.onViewAttachedToWindow(holder);
        holder.itemView.setEnabled(isAllItemsEnabled());
        //or do this in onBindViewHolder()
    }
    @Override
    public boolean isAllItemsEnabled(){ return mAllEnabled; }

    @Override
    public boolean getItemEnabled(int position){
       return true;
    }
    public void setAllItemsEnabled(boolean enable){
      mAllEnabled = enable;
      notifyItemRangeChanged(0, getItemCount());
    }

}