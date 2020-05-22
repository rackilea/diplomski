public abstract class ClickableAdapter<VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {

    private ClickItemListener clickItemListener;

    public void setClickItemListener(ClickItemListener clickItemListener) {
        this.clickItemListener = clickItemListener;
    }


    @Override
    public void onBindViewHolder(@NonNull final VH holder, int position) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clickItemListener != null)
                    clickItemListener.onClickItem(holder.itemView, holder.getAdapterPosition());
                else
                    throw new IllegalStateException("Click listener not set");
            }
        });
    }

    public interface ClickItemListener {
        void onClickItem(View v, int position);
    }
}