@Override
public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
  menu.setHeaderTitle("My twitter menu");
  menu.add(Menu.NONE, 0, 0, "Remove");
}

@Override
public boolean onContextItemSelected(MenuItem item) {
  final int mId = item.getItemId();

  switch (mId) {
    case 0:
      ...        
      break;

    default:
      break;
  }

  return true;
}