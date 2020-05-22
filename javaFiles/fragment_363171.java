@Override
public boolean onOptionsItemSelected(MenuItem item) {
    // Handle item selection
    switch (item.getItemId()) {
        case R.id.action_settings:
          // do your work
            return true;

        default:
            return super.onOptionsItemSelected(item);
    }
}