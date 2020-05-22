JMenu menu = new JMenu("Bookmarks");
menu.addMenuListener(new MyMenuListener());

private class MyMenuListener implements MenuListener {

    public void menuCanceled(MenuEvent e) { }

    public void menuDeselected(MenuEvent e) { }

    public void menuSelected(MenuEvent e) {
        JMenu menu = (JMenu) e.getSource();
        populateWindowMenu(menu);
    }
}

void populateWindowMenu(JMenu windowMenu) {
    windowMenu.removeAll();
    // Populate the menu here
}