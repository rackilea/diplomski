/**
 * Creates the context menu
 *
 * @param viewer
 */
protected void createContextMenu(Viewer viewer) {
    MenuManager contextMenu = new MenuManager("#ViewerMenu"); //$NON-NLS-1$
    contextMenu.setRemoveAllWhenShown(true);
    contextMenu.addMenuListener(new IMenuListener() {
        @Override
        public void menuAboutToShow(IMenuManager mgr) {
            fillContextMenu(mgr);
        }
    });

    Menu menu = contextMenu.createContextMenu(viewer.getControl());
    viewer.getControl().setMenu(menu);
}

/**
 * Fill dynamic context menu
 *
 * @param contextMenu
 */
protected void fillContextMenu(IMenuManager contextMenu) {
    contextMenu.add(new GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));

    contextMenu.add(new Action("Do Something") {
        @Override
        public void run() {
            // implement this
        }
    });
    contextMenu.add(new Action("Do Nothing") {
        @Override
        public void run() {
            // don't do anything here
        }
    });
    contextMenu.add(new Action("Delete") {
        @Override
        public void run() {
            // implement this
        }
    });
}