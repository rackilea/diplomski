@Override
public void onBackPressed() {
    super.onBackPressed();
}

@Override
public boolean onOptionsItemSelected(MenuItem item) {
    int id = item.getItemId();
    if (id == android.R.id.home) {
        onBackPressed();
        return true;
    }
    return super.onOptionsItemSelected(item);
}