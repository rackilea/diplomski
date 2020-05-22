for(int i = 0; i<=mItem.size();i++)
 {
     songList.add(mItem.get(i).getArtist());
 }

 myadapter = new ArrayAdapter<String>         
(YourActivity.this, android.R.layout.simple_list_item_1, songList);