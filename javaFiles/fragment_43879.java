public void onItemClick(AdapterView<?> adv, View v, int arg2, long arg3) {
    // TODO Auto-generated method stub

    switch(adv.getId()) {
        case R.id.ListView1:
            Toast.makeText(this, "list1", Toast.LENGTH_LONG).show();
            break;
        case R.id.ListView2:
            Toast.makeText(this, "list2", Toast.LENGTH_LONG).show();
            break;
    }

}