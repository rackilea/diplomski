public class ViewHolder extends RecyclerView.ViewHolder {
TextView product_name;

ViewHolder(View itemView) {
    super(itemView);
    product_name = (TextView) itemView.findViewById(R.id.product_name);
    itemView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int itemPosition = getLayoutPosition();
            Toast.makeText(getApplicationContext(), itemPosition + ":" + String.valueOf(product_name.getText()), Toast.LENGTH_SHORT).show();
        }
    });
}
}