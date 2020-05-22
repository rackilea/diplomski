@Override
protected void onListItemClick(ListView l, View v, int position, long id) {

     if(adapter.getItem(position).equals("Triangle")){
         adapter.clear();
         for(String item : triangle){
            adapter.add(item);
         }
         adapter.notifyDataSetChanged();
     }else if(...)
}