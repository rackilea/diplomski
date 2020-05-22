public void onListItemClick(ListView l, View v, int position, long id) {
    if (position == 3) {
        Intent intent = new Intent(this, Bradford.class);
        startActivity(intent);
    }
}