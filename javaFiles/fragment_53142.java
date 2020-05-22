if (infodata.get(position).isclicked) {
   infodata.get(position).isclicked = false;
   //Remove it if you want to
   //arrayList.remove(data.get(i).getId());
} else {
   infodata.get(position).isclicked = true;
   arrayList.add(data.get(i).getId());
}