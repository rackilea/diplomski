public void onItemClick(AdapterView parent, View v, int position, long anid) 
    {
        Intent x = new Intent(Menu.this, Account_View.class);
        x.putExtra("Id", id[position]);
        startActivity(x);
    }