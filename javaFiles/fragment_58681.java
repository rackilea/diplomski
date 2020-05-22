@Override
public void onCreateOptionsMenu(Menu menu, MenuInflater inflater)
{       
menu.add(0, MENU_RESET, 0,
getResources().getString(R.string.ram_bar_button_reset))  // <---- Changed Here
    .setIcon(getResources().getDrawable(R.drawable.ic_settings_backup))  // <-- Changed Here
    .setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);   
}