@Override
public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
        // Respond to the action bar's Up/Home button
        case android.R.id.home:

        ....
        Intent resultIntent = new Intent();
        resultIntent.putExtra("noteJSON", noteJSON.toString());
        setResult(Activity.RESULT_OK, resultIntent);
        this.finish();

        return true;
    }
    return super.onOptionsItemSelected(item);
}