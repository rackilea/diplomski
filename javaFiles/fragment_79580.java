@Override
public boolean onCreateOptionsMenu(com.actionbarsherlock.view.Menu menu) {

    com.actionbarsherlock.view.MenuInflater inflate = getSupportMenuInflater();
    inflate.inflate(R.menu.main, menu);

    return super.onCreateOptionsMenu(menu);
}


@Override
public boolean onOptionsItemSelected(com.actionbarsherlock.view.MenuItem item) {
    // Handle item selection
    switch (item.getItemId()) {
        case R.id.action_refresh:
            //do whatever you want
        break;
        default:
            return super.onOptionsItemSelected(item);
    }
}