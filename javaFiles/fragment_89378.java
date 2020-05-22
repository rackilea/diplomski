@Override
public boolean onOptionsItemSelected(MenuItem item) {

    switch (item.getItemId()) {
        case android.R.id.home: {
            finish();
            return true; // make sure to return true here.
        }
    }
    return super.onOptionsItemSelected(item);
}