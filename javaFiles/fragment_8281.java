@Override
public void onClick(View v) {
    if (itemClickListener!=null) {
        previousSelectedPosition = getAdapterPosition();

        notifyDataSetChanged();

        itemClickListener.onItemClick(v,this.getLayoutPosition(),dataType,getOldPosition());
    }
}