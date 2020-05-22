private boolean applyMenuChoice(MenuItem item)
   {
      AdapterContextMenuInfo info = (AdapterContextMenuInfo) item.getMenuInfo();

      switch (item.getItemId())
      {
         case MENU_EDIT_ITEM:
         {
            // Since the user wants to edit an existing device we need to pass the
            // database id of the device - not it's position - to the details screen
            long idNum = info.id;
            Intent i = new Intent(getApplicationContext(), DeviceDataActivity.class);
            i.putExtra(DeviceListViewActivity.ID_EXTRA, String.valueOf(idNum));
            startActivityForResult(i, 0);
            break;
         }
         case MENU_REMOVE_ITEM:
         {
            long idNum = info.id;
            deviceDatabaseHelper.deleteItem(String.valueOf(idNum));
            initList();
            break;
         }
         default:
         {
            return false;
         }
      }
      return true;

   }// end applyMenuChoice