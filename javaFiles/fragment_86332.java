int counter = 0;
LatLngBounds.Builder builder = new LatLngBounds.Builder();
for(int x = firstVisibleItem; x < lastVisibleItem; x++){
    counter++;
    builder.include(temp.getPosition());
}
if (counter > 0) {
    //use a LatLngBounds.Builder to build the LatLngBounds object
}