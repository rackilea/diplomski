Cursor c = nadapter.queueAll();
if (c != null && c.getCount() > 0) {
   // set Adapter
}
else {
   Toast.makeText(this, "Cursor is empty", Toast.LENGTH_SHORT).show();
}