public static class MyItemHolder extends RecyclerView.ViewHolder {
    ImageView mImg;  
    TextView mTextView; 


    public MyItemHolder(View itemView) {
        super(itemView);
        mTextView = (TextView) itemView.findViewById(R.id.item_textview);
        mImg = (ImageView) itemView.findViewById(R.id.item_img);
        }
    }  


@Override
public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        Glide.with(context).load(data.get(position).getUrl())
                .thumbnail(0.5f)
                .override(200,200)
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(((MyItemHolder) holder).mImg);  
        holder.mTextView.setText(data.get(position).getName());

}