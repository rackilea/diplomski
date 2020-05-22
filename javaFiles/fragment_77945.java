@Override
public boolean onOptionsItemSelected(MenuItem item) {
    RelativeLayout  bkgr = (RelativeLayout) findViewById(R.id.utilayout);
    switch (item.getItemId()) {
        case R.id.action_black:
            bkgr.setBackgroundResource(R.color.black);
            return true;
        case R.id.action_red:
            bkgr.setBackgroundResource(R.color.red);
            return true;
        case R.id.action_hello:
            TextView tv = (TextView) findViewById(R.id.hello1);
            tv.setText("What up people?");
            return true;
    }

    return super.onOptionsItemSelected(item);
}