MyList.setOnItemClickListener(new OnItemClickListener()
   {
      @Override
      public void onItemClick(AdapterView<?> adapter, View v, int position,
            long arg3) 
      {
            String value = (String)adapter.getItemAtPosition(position); 
             Toast.makeText(this,value,Toast.LENGTH_SHORT).show();
             list.remove(position); 
             adapter.notifyDataSetChanged();
            // do what you intend to do on click of listview row
      }
   });