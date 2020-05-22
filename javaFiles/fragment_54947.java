if(position<itemList.size()){
       //TO REMOVE TEM FROM ARRAY LIST
      itemList.remove(position);
      //TO Update the ListView
      notifyDataSetChanged();
}