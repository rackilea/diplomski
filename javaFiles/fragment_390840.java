fontsListView.setOnItemClickListener(new OnItemClickListener()
   {
      @Override
      public void onItemClick(AdapterView<?> adapter, View v, int position,
            long arg3) 
      {
            String value = fonts[position] ;
            // assuming string and if you want to get the value on click of list item
            // do what you intend to do on click of listview row
      }
   });