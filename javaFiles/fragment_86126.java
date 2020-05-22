public static class CustomViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

CustomViewHolder(View itemView){
super(itemView);
yourview.setOnClickListener(this);
}
@Override
        public void onClick(View view) {
            onItemClickListener.onItemClicked(view, getAdapterPosition());
        }
}