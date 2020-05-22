public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    Intent i = new Intent(this, second.class);
    i.putExtra("position", position);
    startActivity(i);
}