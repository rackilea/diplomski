@Override
public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
    // Just prepare ourself for unexpected arguments...
    if (menuInfo == null) {
        return;
    }
    if (!(menuInfo instanceof AdapterContextMenuInfo)) {
        return;
    }
    AdapterContextMenuInfo mi = (AdapterContextMenuInfo)menuInfo;
    switch (mi.position) {
    case 0:
        menu.add("cat menu");
        break;
    case 1:
        menu.add("hippopotamus menu");
        break;
    case 2:
        menu.add("monkey menu");
        break;
    case 3:
        menu.add("mouse menu");
        break;
    case 4:
        menu.add("panda menu");
        break;
    case 5:
        menu.add("rabbit menu");
        break;
    default:
        break;
    }
    super.onCreateContextMenu(menu, v, menuInfo);
}