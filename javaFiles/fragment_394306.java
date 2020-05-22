@Override

public void onItemClick(View view, int position){
    Intent intent = new Intent(this, ItemDetailActivity.class);
    intent.putExtra(ITEM_TRANSFER, item);
    startActivity(intent);
}