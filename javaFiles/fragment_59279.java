@Override
public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
    super.onCreateContextMenu(menu, v, menuInfo);
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.context_menu, menu);
    //Set a title for the context menu
    menu.setHeaderTitle("Title of menu");

    // Select a menu item then change it's title (text)
    MenuItem mi = (MenuItem) menu.findItem(R.id.new_game);
    mi.setTitle("Text of item");
}