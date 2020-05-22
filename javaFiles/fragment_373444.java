@Override
public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
    case android.R.id.home:
        //do your own thing here
        return true;
    default: return super.onOptionsItemSelected(item);  
    }
}