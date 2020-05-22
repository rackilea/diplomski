@Override
public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
    case android.R.id.home:
        // Respond to the action bar's Up/Home button
        return false;
    }
    return super.onOptionsItemSelected(item);
}