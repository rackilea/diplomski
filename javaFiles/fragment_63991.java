public void doLayout() {
    super.doLayout();
    List<Component> icons = new ArrayList<Component>(25);
    int maxLayer = 0;
    for (Component comp : getComponents()) {
        if (comp instanceof JInternalFrame.JDesktopIcon) {
            icons.add(comp);
            maxLayer = Math.max(getLayer(comp), maxLayer);
        }
    }

    maxLayer++;
    int x = 0;
    for (Component icon : icons) {

        int y = getHeight() - icon.getHeight();
        icon.setLocation(x, y);
        x += icon.getWidth();
        setLayer(icon, maxLayer);

    }
}