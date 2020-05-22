private void deletePlace(int position){
      PlaceDbhelper dbHelper = new PlaceDbhelper(MainActivity.this);
      dbHelper.removePlace(placeArraylist.get(position).getPlaceId());
      placeArraylist.remove(position);
      mAdapter.notifyDataSetChanged();
}