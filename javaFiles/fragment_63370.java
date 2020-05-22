final int MENU_RINGTONE = 0;
final int MENU_NOTIFICATION = 1;

public void onCreateContextMenu(ContextMenu menu, View v, 
            ContextMenuInfo menuInfo) { 
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(0, MENU_RINGTONE, 0, "Ringtone"); 
        menu.add(0, MENU_NOTIFICATION, 0, "Notification"); 
} 

public boolean onContextItemSelected(MenuItem item) { 
        AdapterContextMenuInfo info = (AdapterContextMenuInfo) item.getMenuInfo();
        long buttonId = info.id;
        switch (item.getItemId()) { 
    case MENU_RINGTONE:
            function1(buttonId);
            break;
    case MENU_NOTIFICATION:
            function2(buttonId);
            break;
    }
}