int selectedPosition;
...
onItemClickListener(int position, ...) {
   selectedPosition = position;
}
...
getView(int position, ...) {

   if (selectedPosition == position) {
      view.setSelected(true);
   } else {
      view.setSelected(false);
   }
}