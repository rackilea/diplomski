@Override
public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g.create();

    for (Relationship relationship : relationships) {

        Point2D p1 = new Point2D.Double(relationship.getParent().getBounds().getCenterX(), relationship.getParent().getBounds().getCenterY());
        Point2D p2 = new Point2D.Double(relationship.getChild().getBounds().getCenterX(), relationship.getChild().getBounds().getCenterY());

        g2.draw(new Line2D.Double(p1, p2));

    }

    for (Person p : persons) {
        p.paint(this, g2);
    }
    for (Fruit f : fruits) {
        f.paint(this, g2);
    }

    g2.dispose();
}