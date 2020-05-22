private MenuModel createMenuModel() {
    MenuModel model = new DefaultMenuModel();
    List<Item> rootItems = searchParentlessItems();
    for (Item item : rootItems) {
        boolean hasChildren = countItemChildren(item) > 0;
        if (hasChildren) {
            SubMenu subMenu = createSubMenu(item);
            model.addElement(subMenu);
            appendChildren(subMenu, item);
        } else {
            MenuItem menuItem = createMenuItem(item);
            model.addElement(menuItem);
        }
    }
}

private void appendChildren(MenuGroup parentMenuItem, Item parentItem) {
    List<Item> children = searchItemChildren(parentItem);
    for (Item child : children) {
        boolean hasChildren = countItemChildren(child) > 0;
        if (hasChildren) {
            SubMenu subMenu = createSubMenu(child);
            parentMenuItem.addElement(subMenu);
            appendChildren(subMenu, child);
        } else {
            MenuItem menuItem = createMenuItem(child);
            parentMenuItem.addElement(menuItem);
        }
    }
}