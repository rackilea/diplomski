@Override
public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
    case android.R.id.home:
//add what you want to do here...
        return true;
    default:
        return super.onOptionsItemSelected(item);
    }
}