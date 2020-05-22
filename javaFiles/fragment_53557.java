@Override
public boolean onOptionsItemSelected(MenuItem menuItem) {
    if (menuItem.getItemId() == android.R.id.home) {
        onBackPressed();
    }
    return super.onOptionsItemSelected(menuItem);
}