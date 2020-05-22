yourlistview.setOnItemClickListener(new AdapterView.OnItemClickListener() 
{ 
 @Override 
  public void onItemClick(AdapterView<?>     parent,View view, int position, long id) 
    { 
       selectedposition = position ;
     }
  });


  View view = listView.getAdapter().getView(selectedposition,null,listview);