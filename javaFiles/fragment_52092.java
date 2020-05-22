@Override
public boolean onCreateOptionsMenu(Menu menu) {
    // TODO Auto-generated method stub

    getMenuInflater().inflate(R.menu.main, menu);
    return super.onCreateOptionsMenu(menu);
}

@Override
public boolean onOptionsItemSelected(MenuItem item) {
    // TODO Auto-generated method stub

    switch (item.getItemId()) {
    case R.id.exit:
        finish();
        moveTaskToBack(true);
        return true;

    default:
        return super.onOptionsItemSelected(item);
    }

}