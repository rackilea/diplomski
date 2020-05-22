@Override
public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
      super.onCreateContextMenu(menu, v, menuInfo);

          MenuInflater inflater = getMenuInflater();
          inflater.inflate(R.menu.menu_list, menu);
          return true;


}

@Override
public boolean onContextItemSelected(MenuItem item) {
      AdapterContextMenuInfo info = (AdapterContextMenuInfo) item.getMenuInfo();
      switch(item.getItemId()) {
         case R.id.add:
         // add stuff here
            return true;
          case R.id.edit:
            // edit stuff here
                return true;
          case R.id.delete:
        // remove stuff here
                return true;
          default:
                return super.onContextItemSelected(item);
      }
}