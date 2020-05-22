@Override
public boolean onOptionsItemSelected(MenuItem item) {
    // Handle item selection
    switch (item.getItemId()) {
    case R.id.action_cart:
        dosomething();
        return true;
    default:
        return super.onOptionsItemSelected(item);
    }
}