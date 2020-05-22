public void mouseReleased(MouseEvent event) {
    // Because the rectangles are painted in order, the later
    // rectangles are painted over the eailer ones, so, we reverse
    // the list so we can check for the higher positioned
    // rectangles
    List<Rectangle> copy = new ArrayList<>(rectanglesList);
    Collections.reverse(copy);
    for (Rectangle r : copy) {
        if (r.contains(event.getPoint())) {
            rectanglesList.remove(r);
            break;
        }
    }
    event.getComponent().repaint();
}