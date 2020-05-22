int x = 0;
for (Component icon : icons) {
    int y = getHeight() - icon.getHeight();
    icon.setLocation(x, y);
    x += icon.getWidth();
    setLayer(icon, 10); // <--- Add me
}