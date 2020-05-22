@Override
public boolean onOptionsItemSelected(MenuItem item) {
    if (mDrawerToggle.onOptionsItemSelected(item)) {
        return true;
    }
    Intent i;
    switch (item.getItemId()) {
        case R.id.action_param:
            i = new Intent(this, Settings.class);
            startActivity(i);
            return true;

        case R.id.action_history:
            i = new Intent(this, HistoryMenu.class);
            startActivity(i);
            return true;
    }
    return onOptionsItemSelected(item);
}