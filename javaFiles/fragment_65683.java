public void addIcon(Icon icon, int x, int y) {
    iList.add(icon);
    width = Math.max(width, x + icon.getIconWidth());
    height = Math.max(height, y + icon.getIconHeight());
    coordinates.add(new Point(x, y));
}