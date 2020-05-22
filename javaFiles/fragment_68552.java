private void refreshDrawer() {
    if(pref.getBoolean(Constants.IS_LOGGED_IN,false)){

        result.removeStickyFooterItemAtPosition(..);
        result.addStickyFooterItem(..);
    }else {

        result.removeStickyFooterItemAtPosition(..);
        result.addStickyFooterItem(..);
    }
}

private void goToLogout(){
    SharedPreferences.Editor editor = pref.edit();
    editor.putBoolean(Constants.IS_LOGGED_IN,false);
    editor.putString(Constants.EMAIL,"");
    editor.putString(Constants.NAME,"");
    editor.putString(Constants.UNIQUE_ID,"");
    editor.commit();
   ....
   refreshDrawer()
}