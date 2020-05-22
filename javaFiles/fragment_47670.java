for (Node menu : menuBarMain.lookupAll(".menu")) {
    if (menu.contains(menu.screenToLocal(p))) {
        f = true;
        break;
    }
}