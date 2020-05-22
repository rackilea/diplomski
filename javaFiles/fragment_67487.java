protected void onListItemClick(ListView l, View v, int position, long id) {
    // TODO Auto-generated method stub
    super.onListItemClick(l, v, position, id);

    Product p = allProducts.get(position);
    if (p.isChecked()) { 
        p.setChecked(false);
        l.setItemChecked(position, false);
    } else {
        p.setChecked(true);
        l.setItemChecked(position, true);
    }
}