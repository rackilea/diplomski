@Override
   public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo)
   {
      menu.setHeaderTitle("Update Item");
      menu.add(Menu.NONE, MENU_EDIT_ITEM,   0, "Edit Item");
      menu.add(Menu.NONE, MENU_REMOVE_ITEM, 1, "Remove Item");
   }