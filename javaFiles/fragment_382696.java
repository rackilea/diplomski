class MyArc {
    private Arc2D arc;
    private MyColor myColor;
    private boolean selected;

    public MyArc(Arc2D arc, MyColor myColor) {
        this.arc = arc;
        this.myColor = myColor;
    }

    public boolean contains(Point p) {
        return arc.contains(p);
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public Arc2D getArc() {
        return arc;
    }

    public MyColor getMyColor() {
        return myColor;
    }

    public Color getColor() {
        return selected ? myColor.getBrightColor() : myColor.getDarkColor();
    }

    public void fill(Graphics2D g2) {
        Color oldColor = g2.getColor();
        g2.setColor(getColor());
        g2.fill(arc);
        g2.setColor(oldColor);
    }

}