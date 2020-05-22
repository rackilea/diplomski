@Override
protected void onListItemClick(ListView l, View v, int position, long id) {     
    if(!items.get(position).isGroup()){         
        Category item = (Category)items.get(position);          
        Intent newintent = new Intent(getBaseContext(), CategoryActivity.class);
        newintent.putExtra("pid", item.id);
        startActivity(newintent);
    }       
    super.onListItemClick(l, v, position, id);
}