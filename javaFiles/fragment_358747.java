public static Point getPositionRelativeTo(Component root, Component comp) {
    if (comp.equals(root)) { return new Point(0,0); }
    Point pos = comp.getLocation();
    Point parentOff = getPositionRelativeTo(root, comp.getParent());
    return new Point(pos.x + parentOff.x, pos.y + parentOff.y);
}