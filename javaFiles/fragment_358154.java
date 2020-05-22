myListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
        @Override
        public void onItemClick(AdapterView<?> parent, View v, int position, long id)  {

           intent = new Intent ( context, web.class);
           intent.putExtra("item_name",items.get(position));
           startActivity(intent);
        }
    });