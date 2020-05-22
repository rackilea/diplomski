public void mousePressed(MouseEvent evt) {
    for (Shape shape : group) {
        if (group.contains(evt.getPoint())) {
            // The shape was clicked...
        }
    }
}