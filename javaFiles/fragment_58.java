for ( int i = 0; i < response.length(); i++) {

   modelDBList.add(dblist);

 }
if(dblist != null and dblist.size() > 0){
adapter.notifyDataSetChanged();
}