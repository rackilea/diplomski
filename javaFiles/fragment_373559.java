lv.setOnItemClickListener(new OnItemClickListener()
   {
      @Override
      public void onItemClick(AdapterView<?> adapter, View v, int position,
            long arg3) 
      {
            // based on the item clicked go to the relevant activity
            String clickedItem = (String)adapter.getItemAtPosition(position);
      }
   });