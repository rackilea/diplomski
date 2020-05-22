public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
    case R.id.Menu1:
        Intent myIntent = new Intent(this,About.class);
        startActivity(myIntent);
        return true;
    default:
        return super.onOptionsItemSelected(item);
    }
}