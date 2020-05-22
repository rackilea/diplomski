public class MyHolder extends RecyclerView.ViewHolder {

    public ImageView imageLeft;

    public ImageView imageRight;

    public CustomItemClickListener listenerLeft;

    public CustomItemClickListener listenerRight;

    public MyHolder(View v, CustomItemClickListener listenerLeft, CustomItemClickListener listenerRight) {
        super(v);
        this.listenerLeft = listenerLeft;
        this.listenerRight = listenerRight;
        imageLeft = v.findViewById(R.id.image_left);
        imageRight = v.findViewById(R.id.image_right);

        imageLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listenerLeft.onItemClick(v, getPosition());
            }
        });

        imageRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listenerRight.onItemClick(v, getPosition());
            }
        });
    }
}