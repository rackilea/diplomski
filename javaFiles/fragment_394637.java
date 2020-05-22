public boolean setEnableByName(boolean enable, String itemName) {
   for (int i = 0 ; i <  myJMenu.getItemCount(); i++) {
      JMenuItem item = myJMenu.getItem(i);
      if (item.getName().equals(itemName)) {
          item.setEnabled(enable);
          return true;
      }
   }
   return false;
}