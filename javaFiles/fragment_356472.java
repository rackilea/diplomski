public void onItemClick(AdapterView<?> arg0, View v, int position, long arg3) { //check third argument it automatically get the selected item POSITION
    // TODO Auto-generated method stub
    Intent i;
    switch (position)
    {
    case 0: // first one of the list
        i = new Intent(this, anActivity.class);
        startActivity(i);
        break;
    case 1: // second one of the list.
        i = new Intent(this, anActivity2.class);
        startActivity(i);
        break;
       // and so on...
    }

}